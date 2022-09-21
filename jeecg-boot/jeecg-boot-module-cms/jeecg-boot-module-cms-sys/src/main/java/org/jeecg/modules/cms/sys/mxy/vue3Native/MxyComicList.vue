<template>
  <div>
        <!--查询区域-->
    <div class="jeecg-basic-table-form-container">
      <a-form @keyup.enter.native="reload" :model="queryParam" :label-col="labelCol" :wrapper-col="wrapperCol">
        <a-row :gutter="24">
          <a-col :lg="8">
            <a-form-item label="漫画名">
              <a-input placeholder="请输入漫画名" v-model:value="queryParam.name"></a-input>
            </a-form-item>
          </a-col>
          <a-col :lg="8">
            <a-form-item label="所属分类">
              <j-tree-select v-model:value="queryParam.categoryId" placeholder="请选择所属分类" dict="mxy_comic_category,name,id"  pidValue="0" />
            </a-form-item>
          </a-col>
          <template v-if="toggleSearchStatus">
            <a-col :lg="8">
              <a-form-item label="是否推荐">
                <j-switch placeholder="请选择是否推荐" v-model:value="queryParam.isRecommend" :options="[1,0]" query />
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="更新状态">
                <j-dict-select-tag placeholder="请选择更新状态" v-model:value="queryParam.updateStatus" dictCode="mxy_update_status"/>
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="作者账号">
                <j-select-user-by-dept placeholder="请选择作者账号" v-model:value="queryParam.authorId" />
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="作者名称">
                <a-input placeholder="请输入作者名称" v-model:value="queryParam.authorName"></a-input>
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="文作者">
                <a-input placeholder="请输入文作者" v-model:value="queryParam.characterAuthor"></a-input>
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="图作者">
                <a-input placeholder="请输入图作者" v-model:value="queryParam.picAuthor"></a-input>
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="是否付费">
                <j-switch placeholder="请选择是否付费" v-model:value="queryParam.isNeedPay" :options="[1,0]" query />
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="是否被锁定">
                <j-switch placeholder="请选择是否被锁定" v-model:value="queryParam.isLocked" :options="[1,0]" query />
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="采集来源标识符">
                <a-input placeholder="请输入采集来源标识符" v-model:value="queryParam.crawlOriginIdentity"></a-input>
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="审核状态">
                <j-dict-select-tag placeholder="请选择审核状态" v-model:value="queryParam.examineStatus" dictCode="mxy_examine_status"/>
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="创建日期">
                <a-date-picker showTime valueFormat="YYYY-MM-DD HH:mm:ss" placeholder="请选择创建日期" v-model:value="queryParam.createTime" />
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="更新日期">
                <a-date-picker showTime valueFormat="YYYY-MM-DD HH:mm:ss" placeholder="请选择更新日期" v-model:value="queryParam.updateTime" />
              </a-form-item>
            </a-col>
            <a-col :lg="8">
              <a-form-item label="删除日期">
                <a-date-picker showTime valueFormat="YYYY-MM-DD HH:mm:ss" placeholder="请选择删除日期" v-model:value="queryParam.deleteTime" />
              </a-form-item>
            </a-col>
          </template>
          <a-col :xl="6" :lg="7" :md="8" :sm="24">
            <span style="float: left; overflow: hidden" class="table-page-search-submitButtons">
              <a-col :lg="6">
                <a-button type="primary" preIcon="ant-design:search-outlined" @click="reload">查询</a-button>
                <a-button preIcon="ant-design:reload-outlined" @click="searchReset" style="margin-left: 8px">重置</a-button>
                <a @click="toggleSearchStatus = !toggleSearchStatus" style="margin-left: 8px">
                  {{ toggleSearchStatus ? '收起' : '展开' }}
                  <Icon :icon="toggleSearchStatus ? 'ant-design:up-outlined' : 'ant-design:down-outlined'" />
                </a>
              </a-col>
            </span>
          </a-col>
        </a-row>
      </a-form>
    </div>
    <!--引用表格-->
   <BasicTable @register="registerTable" :rowSelection="rowSelection">
     <!--插槽:table标题-->
      <template #tableTitle>
          <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined"> 新增</a-button>
          <a-button  type="primary" preIcon="ant-design:export-outlined" @click="onExportXls"> 导出</a-button>
          <j-upload-button  type="primary" preIcon="ant-design:import-outlined" @click="onImportXls">导入</j-upload-button>
          <a-dropdown v-if="selectedRowKeys.length > 0">
              <template #overlay>
                <a-menu>
                  <a-menu-item key="1" @click="batchHandleDelete">
                    <Icon icon="ant-design:delete-outlined"></Icon>
                    删除
                  </a-menu-item>
                </a-menu>
              </template>
              <a-button>批量操作
                <Icon icon="mdi:chevron-down"></Icon>
              </a-button>
        </a-dropdown>
      </template>
       <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)" :dropDownActions="getDropDownAction(record)"/>
      </template>
      <!--字段回显插槽-->
      <template #htmlSlot="{text}">
         <div v-html="text"></div>
      </template>
      <!--省市区字段回显插槽-->
      <template #pcaSlot="{text}">
        {{ getAreaTextByCode(text) }}
      </template>
      <template #fileSlot="{text}">
         <span v-if="!text" style="font-size: 12px;font-style: italic;">无文件</span>
         <a-button v-else :ghost="true" type="primary" preIcon="ant-design:download-outlined" size="small" @click="downloadFile(text)">下载</a-button>
      </template>
    </BasicTable>
    <!-- 表单区域 -->
    <MxyComicModal @register="registerModal" @success="handleSuccess"></MxyComicModal>
  </div>
</template>

<script lang="ts" name="mxy-mxyComic" setup>
  import {ref, reactive, computed, unref} from 'vue';
  import {BasicTable, useTable, TableAction} from '/@/components/Table';
  import { useListPage } from '/@/hooks/system/useListPage'
  import {useModal} from '/@/components/Modal';
  import MxyComicModal from './components/MxyComicModal.vue'
  import {columns, searchFormSchema} from './MxyComic.data';
  import {list, deleteOne, batchDelete, getImportUrl,getExportUrl} from './MxyComic.api';
  import {downloadFile} from '/@/utils/common/renderUtils';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import JSwitch from '/@/components/Form/src/jeecg/components/JSwitch.vue';
  import JSelectUserByDept from '/@/components/Form/src/jeecg/components/JSelectUserByDept.vue';
  import JTreeSelect from '/@/components/Form/src/jeecg/components/JTreeSelect.vue';
  const checkedKeys = ref<Array<string | number>>([]);
  //注册model
  const [registerModal, {openModal}] = useModal();
   //注册table数据
  const { prefixCls,tableContext,onExportXls,onImportXls } = useListPage({
      tableProps:{
           title: '漫画列表',
           api: list,
           columns,
           canResize:false,
           useSearchForm: false,
           actionColumn: {
               width: 120,
               fixed:'right'
           },
           beforeFetch: (params) => {
             return Object.assign(params, queryParam.value);
           },
        },
        exportConfig: {
            name:"漫画列表",
            url: getExportUrl,
        },
        importConfig: {
            url: getImportUrl,
            success: handleSuccess
        },
    })

  const [registerTable, {reload},{ rowSelection, selectedRowKeys }] = tableContext

   /**
    * 新增事件
    */
  function handleAdd() {
     openModal(true, {
       isUpdate: false,
       showFooter: true,
     });
  }
   /**
    * 编辑事件
    */
  function handleEdit(record: Recordable) {
     openModal(true, {
       record,
       isUpdate: true,
       showFooter: true,
     });
   }
   /**
    * 详情
   */
  function handleDetail(record: Recordable) {
     openModal(true, {
       record,
       isUpdate: true,
       showFooter: false,
     });
   }
   /**
    * 删除事件
    */
  async function handleDelete(record) {
     await deleteOne({id: record.id}, handleSuccess);
   }
   /**
    * 批量删除事件
    */
  async function batchHandleDelete() {
     await batchDelete({ids: selectedRowKeys.value},handleSuccess);
   }
   /**
    * 成功回调
    */
  function handleSuccess() {
      (selectedRowKeys.value = []) && reload();
   }
   /**
      * 操作栏
      */
  function getTableAction(record){
       return [
         {
           label: '编辑',
           onClick: handleEdit.bind(null, record),
         }
       ]
   }
     /**
        * 下拉操作栏
        */
  function getDropDownAction(record){
      return [
           {
             label: '详情',
             onClick: handleDetail.bind(null, record),
           }, {
             label: '删除',
             popConfirm: {
               title: '是否确认删除',
               confirm: handleDelete.bind(null, record),
             }
           }
      ]
   }

  /* ----------------------以下为原生查询需要添加的-------------------------- */
  const queryParam = ref<any>({});
  const toggleSearchStatus = ref<boolean>(false);
  const labelCol = reactive({
    xs: { span: 24 },
    sm: { span: 7 },
  });
  const wrapperCol = reactive({
    xs: { span: 24 },
    sm: { span: 16 },
  });
  /**
   * 重置
   */
  function searchReset() {
    queryParam.value = {};
    selectedRowKeys.value = [];
    //刷新数据
    reload();
  }

</script>
<style lang="less" scoped>
  .jeecg-basic-table-form-container {
  .table-page-search-submitButtons {
    display: block;
    margin-bottom: 24px;
    white-space: nowrap;
  }
  .query-group-cust{
    width: calc(50% - 15px);
    min-width: 100px !important;
  }
  .query-group-split-cust{
    width: 30px;
    display: inline-block;
    text-align: center
  }
  }
</style>