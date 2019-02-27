<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameAllLower = table.classNameLowerCase>
<#include "/java_copyright.include">

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
            <#list table.columns as column>
                <el-table-column prop="${column.columnNameLower}" label="${column.columnAlias}" width="160"></el-table-column>
            </#list>

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
                <#list table.columns as column>
                    <el-form-item label="${column.columnAlias}">
                        <el-input v-model="temp.${column.columnNameLower}"></el-input>
                    </el-form-item>
                </#list>
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
    import { fetchList, delete${className}, insert${className}, update${className}} from 'api/${tableNameAllLower}';

    export default {
        name: '${className}_INDEX',
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
                    <#list table.columns as column>
                    ${column.columnNameLower} : '', //${column.columnAlias} ${column.simpleJavaType}
                    </#list>
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
                insert${className} (this.temp).then(response => {
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
                update${className} (this.temp).then(response => {
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
                        delete${className} (postData).then(response => {
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
                    <#list table.columns as column>
                    ${column.columnNameLower} : '',
                    </#list>
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
