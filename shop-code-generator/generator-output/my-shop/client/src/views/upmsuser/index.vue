/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


<template>
    <div class="app-container calendar-list-container">

        <!-- 搜索条件 -->
        <div class="filter-container">
            <el-input @keyup.enter.native="handleFilter" style="width: 200px;" class="filter-item" placeholder="查询条件" v-model="listQuery.XXXXXXX">
            </el-input>

            <el-button class="filter-item" type="primary" v-waves icon="search" @click="handleFilter">搜索</el-button>
            <el-button class="filter-item" style="margin-left: 10px;" @click="showCreate" type="primary" icon="edit">添加</el-button>
        </div>

        <el-table :data="list" style="width: 100%">
                <el-table-column prop="id" label="编号" width="160"></el-table-column>
                <el-table-column prop="username" label="帐号" width="160"></el-table-column>
                <el-table-column prop="password" label="密码MD5(密码+盐)" width="160"></el-table-column>
                <el-table-column prop="salt" label="盐" width="160"></el-table-column>
                <el-table-column prop="realname" label="姓名" width="160"></el-table-column>
                <el-table-column prop="avatar" label="头像" width="160"></el-table-column>
                <el-table-column prop="phone" label="电话" width="160"></el-table-column>
                <el-table-column prop="email" label="邮箱" width="160"></el-table-column>
                <el-table-column prop="sex" label="性别" width="160"></el-table-column>
                <el-table-column prop="locked" label="状态(0:正常,1:锁定)" width="160"></el-table-column>
                <el-table-column prop="createTime" label="创建时间" width="160"></el-table-column>
                <el-table-column prop="updateTime" label="修改时间" width="160"></el-table-column>

            <el-table-column  align="center" label="操作">
                <template scope="scope">
                    <el-button size="small" type="success" @click="showUpdate(scope.row)">编辑
                    </el-button>
                    <el-button size="small" type="danger" @click="handleDelete(scope.row)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <div v-show="!listLoading" class="pagination-container">
            <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="listQuery.page" :page-sizes="[10,20,30, 50]"
                           :page-size="listQuery.limit" layout="total, sizes, prev, pager, next, jumper" :total="total">
            </el-pagination>
        </div>

        <!--    =====  编辑页面 starter  =====   -->
        <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
            <el-form class="small-space" :model="temp" label-position="left" label-width="70px" style='width: 400px; margin-left:50px;'>
                    <el-form-item label="编号">
                        <el-input v-model="temp.id"></el-input>
                    </el-form-item>
                    <el-form-item label="帐号">
                        <el-input v-model="temp.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码MD5(密码+盐)">
                        <el-input v-model="temp.password"></el-input>
                    </el-form-item>
                    <el-form-item label="盐">
                        <el-input v-model="temp.salt"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名">
                        <el-input v-model="temp.realname"></el-input>
                    </el-form-item>
                    <el-form-item label="头像">
                        <el-input v-model="temp.avatar"></el-input>
                    </el-form-item>
                    <el-form-item label="电话">
                        <el-input v-model="temp.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱">
                        <el-input v-model="temp.email"></el-input>
                    </el-form-item>
                    <el-form-item label="性别">
                        <el-input v-model="temp.sex"></el-input>
                    </el-form-item>
                    <el-form-item label="状态(0:正常,1:锁定)">
                        <el-input v-model="temp.locked"></el-input>
                    </el-form-item>
                    <el-form-item label="创建时间">
                        <el-input v-model="temp.createTime"></el-input>
                    </el-form-item>
                    <el-form-item label="修改时间">
                        <el-input v-model="temp.updateTime"></el-input>
                    </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button v-if="dialogStatus=='create'" type="primary" @click="handleCreate">确 定</el-button>
                <el-button v-else type="primary" @click="handleUpdate">确 定</el-button>
            </div>
        </el-dialog>
        <!--    =====  编辑页面    end  =====   -->
    </div>
</template>


<script>
    import { fetchList, deleteUpmsUser, insertUpmsUser, updateUpmsUser} from 'api/upmsuser';

    export default {
        name: 'UpmsUser_INDEX',
        data() {
            return {
                list: null,
                total: null,
                listLoading: true,
                listQuery: {
                    page: 1,
                    limit: 20,
                    importance: undefined,
                    title: undefined,
                    type: undefined,
                    sort: '+id'
                },
                temp: {
                    id : '', //编号 Integer
                    username : '', //帐号 String
                    password : '', //密码MD5(密码+盐) String
                    salt : '', //盐 String
                    realname : '', //姓名 String
                    avatar : '', //头像 String
                    phone : '', //电话 String
                    email : '', //邮箱 String
                    sex : '', //性别 Integer
                    locked : '', //状态(0:正常,1:锁定) Integer
                    createTime : '', //创建时间 Long
                    updateTime : '', //修改时间 Long
                },
                dialogFormVisible: false,
                dialogStatus: '',
                textMap: {
                    update: '编辑',
                    create: '创建'
                },
                tableKey: 0
            }
        },
        created() {
            this.getList();
        },
        filters: {
            typeFilter(type) {
                return userTypeKeyValue[type]
            }
        },
        methods: {
            getList() {
                //查询列表
                this.listLoading = true;
                fetchList(this.listQuery).then(response => {
                    this.list = response.data.data.itemList;
                    this.total = response.data.totalCount;
                    this.listLoading = false;
                })
            },
            handleFilter() {
                //根据条件查询
                this.getList();
            },

            showCreate() {
                this.resetTemp();
                this.dialogStatus = 'create';
                this.dialogFormVisible = true;
            },
            showUpdate(row) {
                this.temp = Object.assign({}, row);
                this.dialogStatus = 'update';
                this.dialogFormVisible = true;
            },
            handleCreate () {
                insertUpmsUser (this.temp).then(response => {
                    this.dialogFormVisible = false;
                    this.$notify({
                        title: '成功', message: '创建成功', type: 'success', duration: 2000
                    });
                    //再次加载数据
                    this.getList();
                });
            },
            // update() {
            handleUpdate () {
                updateUpmsUser (this.temp).then(response => {
                    this.dialogFormVisible = false;
                    this.$notify({
                        title: '成功', message: '保存成功', type: 'success', duration: 2000
                    });
                    //再次加载数据
                    this.getList();
                });
            },
            handleDelete(row) {
                this.$confirm('确认删除用户 [ ' + row.id +' ]？')
                    .then(_ => {
                        //删除用户数据
                        var postData = { "id" : row.id};
                        deleteUpmsUser (postData).then(response => {
                            this.$notify({
                                title: '成功', message: '删除成功', type: 'success', duration: 2000
                            });
                            //再次加载数据
                            this.getList();
                        });
                    })
                    .catch(_ => {});
            },
            resetTemp() {
                this.temp = {
                    id : '',
                    username : '',
                    password : '',
                    salt : '',
                    realname : '',
                    avatar : '',
                    phone : '',
                    email : '',
                    sex : '',
                    locked : '',
                    createTime : '',
                    updateTime : '',
                };
            },
            // ======= 分页相关 =======
            handleSizeChange(val) {
                this.listQuery.limit = val;
                this.getList();
            },
            handleCurrentChange(val) {
                this.listQuery.page = val;
                this.getList();
            },
        }
    }


</script>
