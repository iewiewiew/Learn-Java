<template>
    <div class="app-container">
        <el-table v-loading="loading" :data="tableData" border style="width: 100%;">
            <!-- 在 Vue.js 中，<el-table> 组件的 prop 属性用于指定数据源中对应的字段。例如：prop="id" 表示该列将显示 tableData 中每个对象的 id 字段的值。 -->
            <el-table-column align="center" prop="id" label="ID" width="100%" fixed="left"> </el-table-column>
            <el-table-column align="center" prop="username" label="用户名称" width="160"></el-table-column>
            <el-table-column align="center" prop="age" label="年龄" width="160"></el-table-column>
            <el-table-column align="center" prop="mark" label="备注" width="160"></el-table-column>
            <el-table-column align="center" prop="creater" label="创建人" width="160"></el-table-column>
            <el-table-column align="center" prop="updater" label="更新人" width="160"></el-table-column>
            <el-table-column align="center" prop="createTime" label="创建时间" width="180" show-overflow-tooltip>
                <template v-slot:default="scope">
                    <!-- 移除过滤器语法 -->
                    <!-- <span>{{ scope.row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span> -->
                    <i v-if="scope.row.createTime" class="el-icon-time" />
                    <span>{{ formatTime(scope.row.createTime) }}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" prop="updateTime" label="更新时间" width="180" show-overflow-tooltip>
                <template v-slot:default="scope">
                    <i v-if="scope.row.updateTime" class="el-icon-time" />
                    <span>{{ formatTime(scope.row.updateTime) }}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" fixed="right" label="操作" width="200">
                <template v-slot:default="scope">
                    <el-button link type="primary" size="small" @click="$refs.addOrUpdateComponent.openDialog(scope.row, 'edit')">编辑</el-button>
                    <el-button type="danger" size="mini" @click="deleteById(scope.row.id, 'id')">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination background @current-change="handleCurrentChange" @size-change="handleSizeChange" :current-page="listQuery.pageNum" :page-size="listQuery.pageSize" layout="total, prev, pager, next, jumper" :total="total">
        </el-pagination>
    </div>
</template>

<script>
import { listByPage } from "@/api/example";
import { parseTime } from "@/utils/utils";


export default {
    data() {
        return {
            loading: true,
            listQuery: {
                id: "",
                username: "",
                age: "",
                mark: "",
                creater: "",
                updater: "",
                createTime: "",
                updateTime: "",
                pageNum: 1,
                pageSize: 10,
            },
            /**
            如使模拟数据，需要注释：this.tableData = response.data;
            tableData: [
                { id: 1, username: 'Alice', age: 28, mark: "备注", creater: 'Admin', updater: 'Admin' },
                { id: 2, username: 'Bob', age: 34, mark: "备注", creater: 'Admin', updater: 'User' },
            ],
            */
            tableData: [],
            total: 0,
        };
    },
    created() {
        this.fetchData();
    },
    methods: {
        // 列表查询
        fetchData() {
            this.loading = true;
            listByPage(this.listQuery).then(response => {
                this.loading = false;
                console.log(response.total);
                this.total = response.total;
                this.tableData = response.data;
            }).catch(error => {
                this.loading = false;
                console.error(error);
            });
        },

        // 格式化时间
        formatTime(time) {
            return parseTime(time, '{y}-{m}-{d} {h}:{i}:{s}');
        },

        // 分页变化
        handleCurrentChange(val) {
            this.listQuery.pageNum = val;
            this.fetchData();
            console.log(`当前页: ${val}`);
        },

        // 分页条数
        handleSizeChange(val) {
            this.listQuery.pageSize = val;
            this.fetchData();
            console.log(`每页 ${val} 条`);
        },
    }
}    
</script>