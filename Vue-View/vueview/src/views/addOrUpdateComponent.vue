<template>
  <div>
    <el-dialog
      center
      v-loading="loading"
      :title="title"
      :visible.sync="dialogVisible"
      width="600px">

      <el-form :model="addOrUpdateForm" :rules="rules" ref="ruleForm" label-width="150px">
        <!-- 隐藏 ID 列
        <el-form-item label="ID" prop="id">
          <el-input style="max-width: 255px" maxlength="40" v-model="addOrUpdateForm.id"></el-input>
        </el-form-item> -->
        <el-form-item label="账号" prop="username">
          <el-input placeholder="账号长度必须是1-10个字符" style="max-width: 255px" maxlength="40" v-model="addOrUpdateForm.username"></el-input>
          <template>
            <el-tooltip class="item" effect="light" content="账号长度必须是1-10个字符" placement="right-start">
              <i class="el-icon-question" />
            </el-tooltip>
          </template>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input placeholder="密码长度必须是1-10个字符" style="max-width: 255px" maxlength="50" v-model="addOrUpdateForm.password"></el-input>
          <template>
            <el-tooltip class="item" effect="light" content="密码长度必须是1-10个字符" placement="right-start">
              <i class="el-icon-question" />
            </el-tooltip>
          </template>
        </el-form-item>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit('ruleForm')">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import {add, update} from '@/api/httpDemo';

export default {
  name: "addOrUpdateComponent",
  data() {
    return {
      loading: false,
      title: "",
      type: "",
      dialogVisible: false,
      addOrUpdateForm: {
        id: "",
        username: "",
        password: "",
      },
      rules: {
        username: [
          {required: true, message: '请输入账号，账号长度必须是1-10个字符', trigger: 'change'},
          { min: 1, max: 10, message: '账号长度必须是1-10个字符', trigger: 'change' }
        ],
        password: [
          {required: true, message: '请输入密码，密码长度必须是1-10个字符', trigger: 'change'},
          { min: 1, max: 10, message: '密码长度必须是1-10个字符', trigger: 'change' }
        ],
      }
    }
  },

  methods: {
    //打开弹窗
    openDialog(row) {
      //将Vue中的data数据初始化一下
      Object.assign(this.$data, this.$options.data());
      this.dialogVisible = true;
      this.init();
      if (row == undefined) {
        this.title = "新增";
        this.type = "add";
      } else {
        this.title = "编辑";
        this.type = "update";
        //拷贝对象
        for (let key in row) {
          this.addOrUpdateForm[key] = row[key];
        }
      }
    },

    init() {

    },

    //提交
    submit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.loading = true;
          if (this.type === 'add') {
            add(this.addOrUpdateForm).then(_ => {
              this.loading = false;
              this.dialogVisible = false;
              this.$emit('refreshData');
              return this.$message.success("新增成功")
            }).catch(e => {
              this.loading = false;
            });
          } else {
            update(this.addOrUpdateForm).then(_ => {
              this.loading = false;
              this.dialogVisible = false;
              this.$emit('refreshData');
              return this.$message.success("更新成功")
            }).catch(e => {
              this.loading = false;
            });
          }
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  }
}
</script>
