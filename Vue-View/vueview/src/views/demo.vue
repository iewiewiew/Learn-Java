<template>
  <div class="app-container">
    <el-select
      v-model="value"
      multiple
      filterable
      remote
      reserve-keyword
      placeholder="请输入关键词"
      :remote-method="remoteMethod"
      :loading="loading">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>

    <el-button style="float: right; margin-right: 120px;margin-bottom: 10px " type="primary" plain
               @click="$refs.addOrUpdateComponent.openDialog()" v-show="showAddTag" >新增
    </el-button>

    <el-table v-loading="loading" :data="tableData" border style="width: 100%">
      <el-table-column align="center" prop="id" label="ID" width="100" fixed="left"></el-table-column>
      <el-table-column align="center" prop="username" label="账号" width="200"></el-table-column>
      <el-table-column align="center" prop="password" label="密码" width="200"></el-table-column>
      <el-table-column align="center" prop="creater" label="创建人" width="200"></el-table-column>
      <el-table-column align="center" prop="updater" label="更新人" width="200"></el-table-column>
      <el-table-column align="center" prop="createTime" label="创建时间" width="200" show-overflow-tooltip>
        <template slot-scope="scope">
          <i v-if="scope.row.createTime" class="el-icon-time"/>
<!--          <span>{{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>-->
          <span>{{scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>

<!--          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}')}}</span>-->
        </template>
      </el-table-column>
      <el-table-column align="center" prop="updateTime" label="更新时间" width="200" show-overflow-tooltip>
        <template slot-scope="scope">
          <i v-if="scope.row.updateTime" class="el-icon-time"/>
          <span>{{ scope.row.updateTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>

      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button link type="primary" size="small"
                     @click="$refs.addOrUpdateComponent.openDialog(scope.row, 'edit')">编辑</el-button>
          <el-button v-preventReClick type="danger" size="mini"
                     @click="del(scope.row.id, 'id')">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
      background
      @current-change="handleCurrentChange"
      :current-page="listQuery.pageNum"
      :page-size="listQuery.pageSize"
      layout="total, prev, pager, next, jumper"
      :total="total"
      @pagination="fetchData">
    </el-pagination>

    <addOrUpdateComponent ref="addOrUpdateComponent" @refreshData="fetchData"></addOrUpdateComponent>
  </div>
</template>


<script>
import {list, listByPage, del} from '@/api/httpDemo'
import Pagination from '@/components/Pagination'
import addOrUpdateComponent from './addOrUpdateComponent.vue'

export default {
  components: {Pagination, addOrUpdateComponent},

  data(){
    return {
      showAddTag: true,
      dialogVisible: false,
      listQuery: {
        id:"",
        username: "",
        password: "",
        createTime: "",
        updateTime: "",
        pageNum: 1,
        pageSize: 10,
      },
      tableData: [],
      total: 0,
    }
  },

  created() {
    this.init();
  },

  methods: {
    init() {
      console.log(this.listQuery)
      listByPage(this.listQuery).then(resp => {
        this.total = resp.total;
        this.tableData = resp.data
      });
    },
    fetchData() {
      this.init();
      this.loading = true;
      listByPage(this.listQuery).then(resp => {
        this.total = resp.total;
        this.tableData = resp.data;
        this.loading = false;
      });
    },
    handleCurrentChange(val) {
      this.listQuery.pageNum = val;
      // this.init();
      listByPage(this.listQuery).then(resp => {
        this.total = resp.total;
        this.tableData = resp.data;
        this.loading = false;
      });
      console.log(`当前页: ${val}`);
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    del(id) {
      debugger
      this.$confirm('确定删除？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        del({"id": id}).then(response => {
          this.$message.success("删除成功！");
          this.fetchData()
        }).catch(() => {
          console.table();
          // this.$message.info("异常！");
        });
      })
    },
  }
}
</script>



