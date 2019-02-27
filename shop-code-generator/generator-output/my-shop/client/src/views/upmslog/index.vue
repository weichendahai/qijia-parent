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
                <el-table-column prop="description" label="操作描述" width="160"></el-table-column>
                <el-table-column prop="username" label="操作用户" width="160"></el-table-column>
                <el-table-column prop="startTime" label="操作时间" width="160"></el-table-column>
                <el-table-column prop="spendTime" label="消耗时间" width="160"></el-table-column>
                <el-table-column prop="basePath" label="根路径" width="160"></el-table-column>
                <el-table-column prop="uri" label="URI" width="160"></el-table-column>
                <el-table-column prop="url" label="URL" width="160"></el-table-column>
                <el-table-column prop="method" label="请求类型" width="160"></el-table-column>
                <el-table-column prop="parameter" label="parameter" width="160"></el-table-column>
                <el-table-column prop="userAgent" label="用户标识" width="160"></el-table-column>
                <el-table-column prop="ip" label="IP地址" width="160"></el-table-column>
                <el-table-column prop="result" label="result" width="160"></el-table-column>
                <el-table-column prop="permissions" label="权限值" width="160"></el-table-column>
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
                    <el-form-item label="操作描述">
                        <el-input v-model="temp.description"></el-input>
                    </el-form-item>
                    <el-form-item label="操作用户">
                        <el-input v-model="temp.username"></el-input>
                    </el-form-item>
                    <el-form-item label="操作时间">
                        <el-input v-model="temp.startTime"></el-input>
                    </el-form-item>
                    <el-form-item label="消耗时间">
                        <el-input v-model="temp.spendTime"></el-input>
                    </el-form-item>
                    <el-form-item label="根路径">
                        <el-input v-model="temp.basePath"></el-input>
                    </el-form-item>
                    <el-form-item label="URI">
                        <el-input v-model="temp.uri"></el-input>
                    </el-form-item>
                    <el-form-item label="URL">
                        <el-input v-model="temp.url"></el-input>
                    </el-form-item>
                    <el-form-item label="请求类型">
                        <el-input v-model="temp.method"></el-input>
                    </el-form-item>
                    <el-form-item label="parameter">
                        <el-input v-model="temp.parameter"></el-input>
                    </el-form-item>
                    <el-form-item label="用户标识">
                        <el-input v-model="temp.userAgent"></el-input>
                    </el-form-item>
                    <el-form-item label="IP地址">
                        <el-input v-model="temp.ip"></el-input>
                    </el-form-item>
                    <el-form-item label="result">
                        <el-input v-model="temp.result"></el-input>
                    </el-form-item>
                    <el-form-item label="权限值">
                        <el-input v-model="temp.permissions"></el-input>
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
    import { fetchList, deleteUpmsLog, insertUpmsLog, updateUpmsLog} from 'api/upmslog';

    export default {
        name: 'UpmsLog_INDEX',
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
                    description : '', //操作描述 String
                    username : '', //操作用户 String
                    startTime : '', //操作时间 Long
                    spendTime : '', //消耗时间 Integer
                    basePath : '', //根路径 String
                    uri : '', //URI String
                    url : '', //URL String
                    method : '', //请求类型 String
                    parameter : '', //parameter String
                    userAgent : '', //用户标识 String
                    ip : '', //IP地址 String
                    result : '', //result String
                    permissions : '', //权限值 String
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
                insertUpmsLog (this.temp).then(response => {
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
                updateUpmsLog (this.temp).then(response => {
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
                        deleteUpmsLog (postData).then(response => {
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
                    description : '',
                    username : '',
                    startTime : '',
                    spendTime : '',
                    basePath : '',
                    uri : '',
                    url : '',
                    method : '',
                    parameter : '',
                    userAgent : '',
                    ip : '',
                    result : '',
                    permissions : '',
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
