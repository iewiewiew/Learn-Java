<template>
  <div class="app-container">
    <el-button
      :loading="downloadLoading"
      style="margin-left:16px;"
      type="primary"
      icon="el-icon-document"
      @click="handleDownload"
    >
      导出 Excel
    </el-button>
    <el-button
      style="float: right; margin-right: 120px; margin-bottom: 10px"
      type="primary"
      plain
      @click="$refs.addOrUpdateComponent.openDialog()"
      v-show="showAddTag"
    >
      新增
    </el-button>
    <el-button type="danger" @click="deleteSelected">批量删除</el-button>

    <el-table
      v-loading="loading"
      ref="table"
      :data="tableData"
      border
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <!-- 勾选框 -->
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column align="center" prop="id" label="ID" width="100" fixed="left"></el-table-column>
      <el-table-column align="center" prop="username" label="账号" width="200"></el-table-column>
      <el-table-column align="center" prop="password" label="密码" width="200"></el-table-column>
      <el-table-column align="center" prop="creater" label="创建人" width="200"></el-table-column>
      <el-table-column align="center" prop="updater" label="更新人" width="200"></el-table-column>

      <el-table-column align="center" prop="createTime" label="创建时间" width="200" show-overflow-tooltip>
        <template v-slot:default="scope">
          <i v-if="scope.row.createTime" class="el-icon-time" />
          <span>{{ formatTime(scope.row.createTime) }}</span>
          <!-- 移除过滤器语法 -->
          <!-- <span>{{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span> -->
        </template>
      </el-table-column>

      <el-table-column align="center" prop="updateTime" label="更新时间" width="200" show-overflow-tooltip>
        <template v-slot:default="scope">
          <i v-if="scope.row.updateTime" class="el-icon-time" />
          <span>{{ formatTime(scope.row.updateTime) }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" fixed="right" label="操作" width="200">
        <template v-slot:default="scope">
          <el-button
            link
            type="primary"
            size="small"
            @click="$refs.addOrUpdateComponent.openDialog(scope.row, 'edit')"
          >
            编辑
          </el-button>
          <el-button
            type="danger"
            size="mini"
            @click="deleteById(scope.row.id, 'id')"
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      background
      @current-change="handleCurrentChange"
      @size-change="handleSizeChange"
      :current-page="listQuery.pageNum"
      :page-size="listQuery.pageSize"
      layout="total, prev, pager, next, jumper"
      :total="total"
    ></el-pagination>

    <addOrUpdateComponent ref="addOrUpdateComponent" @refreshData="fetchData"></addOrUpdateComponent>
  </div>
</template>

<script>
import { listByPage, deleteById, deletebatch } from "@/api/httpDemo";
import { parseTime } from "@/utils/utils";
import addOrUpdateComponent from "./addOrUpdateComponent.vue";

export default {
  components: { addOrUpdateComponent },

  data() {
    return {
      showAddTag: true,
      dialogVisible: false,
      loading: false,
      downloadLoading: false,
      listQuery: {
        id: "",
        ids: "",
        username: "",
        password: "",
        createTime: "",
        updateTime: "",
        pageNum: 1,
        pageSize: 10,
      },
      tableData: [],
      total: 0,
      selectedIds: [], // 存储选中的 ID
    };
  },

  created() {
    this.fetchData();
  },

  methods: {
    // 获取分页查询数据
    fetchData() {
      this.loading = true; // 开始加载状态
      listByPage(this.listQuery)
        .then((resp) => {
          console.log("响应数据:", resp); // 打印响应数据

          // 更新总记录数和表格数据
          this.total = resp.total || 0; // 如果没有总数，默认为0
          this.tableData = Array.isArray(resp.data) ? resp.data : []; // 确保tableData是一个数组
        })
        .catch((error) => {
          console.error("获取数据时出错:", error); // 处理错误
        })
        .finally(() => {
          this.loading = false; // 结束加载状态
        });
    },

    // 导出 Excel
    handleDownload() {
      this.downloadLoading = true;
      import("@/vendor/Export2Excel").then((excel) => {
        const tHeader = [
          "Id",
          "Username",
          "Password",
          "Creater",
          "Updater",
          "CreateTime",
          "UpdateTime",
        ];
        const filterVal = [
          "id",
          "username",
          "password",
          "creater",
          "updater",
          "createTime",
          "updateTime",
        ];
        const list = this.tableData;
        const data = this.formatJson(filterVal, list);
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: "demo",
        });
        this.downloadLoading = false;
      });
    },

    // 格式化 JSON 为 Excel 数据
    formatJson(filterVal, jsonData) {
      return jsonData.map((v) => filterVal.map((j) => v[j]));
    },

    // 分页变化
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      this.fetchData();
      console.log(`当前页: ${val}`);
    },

    handleSizeChange(val) {
      this.listQuery.pageSize = val;
      this.fetchData();
      console.log(`每页 ${val} 条`);
    },

    // 单项删除
    deleteById(id) {
      this.$confirm("确定删除？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          deleteById({ id })
            .then(() => {
              this.$message.success("删除成功！");
              this.fetchData();
            })
            .catch(() => {
              this.$message.error("删除失败！");
            });
        })
        .catch(() => {
          this.$message.error("未知异常")
        });
    },

    // 批量删除
    deleteSelected() {
      if (this.selectedIds.length === 0) {
        this.$message.info("请先选择要删除的项！");
        return;
      }

      this.$confirm("确定批量删除选中的项吗？", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          deletebatch({ ids: this.selectedIds })
            .then(() => {
              this.$message.success("批量删除成功！");
              this.fetchData();
              this.selectedIds = []; // 清空选中项
            })
            .catch(() => {
              this.$message.error("批量删除失败，请重试！");
            });
        })
        .catch(() => {});
    },

    // 监听选中项变化
    handleSelectionChange(selectedRows) {
      this.selectedIds = selectedRows.map((row) => row.id); // 将选中行的 ID 提取出来
    },

    formatTime(time) {
      return parseTime(time, '{y}-{m}-{d} {h}:{i}:{s}');
    },
  },
};
</script>