<template>
  <a-spin :spinning="loading">
    <a-form v-bind="formItemLayout">
      <a-row>
        <a-col :span="12">
          <a-form-item label="漫画名" v-bind="validateInfos.name">
            <a-input v-model:value="formData.name" placeholder="请输入漫画名" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="英文名" v-bind="validateInfos.nameEng">
            <a-input v-model:value="formData.nameEng" placeholder="请输入英文名" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="所属分类" v-bind="validateInfos.categoryId">
	          <j-tree-select
	            dict="mxy_comic_category,name,id"
	            pidValue="0"
	            :disabled="disabled"
	            v-model:value="formData.categoryId"
	            @change="(value) => handleFormChange('categoryId', value)">
	          </j-tree-select>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="是否推荐" v-bind="validateInfos.isRecommend">
	          <j-switch v-model:value="formData.isRecommend" :options="[1,0]" :disabled="disabled"></j-switch>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="竖封面" v-bind="validateInfos.coverVertical">
	          <j-image-upload :fileMax=1 v-model:value="formData.coverVertical" :disabled="disabled"></j-image-upload>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="横封面" v-bind="validateInfos.coverHorizontal">
	          <j-image-upload :fileMax=1 v-model:value="formData.coverHorizontal" :disabled="disabled"></j-image-upload>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="更新状态" v-bind="validateInfos.updateStatus">
	          <j-dict-select-tag v-model:value="formData.updateStatus" dictCode="mxy_update_status" placeholder="请选择更新状态" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="作者账号" v-bind="validateInfos.authorId">
	          <j-select-user-by-dept v-model:value="formData.authorId" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="作者名称" v-bind="validateInfos.authorName">
            <a-input v-model:value="formData.authorName" placeholder="请输入作者名称" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="公告" v-bind="validateInfos.notice">
	          <a-textarea v-model:value="formData.notice" rows="4" placeholder="请输入公告" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="文作者" v-bind="validateInfos.characterAuthor">
            <a-input v-model:value="formData.characterAuthor" placeholder="请输入文作者" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="图作者" v-bind="validateInfos.picAuthor">
            <a-input v-model:value="formData.picAuthor" placeholder="请输入图作者" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="短介绍" v-bind="validateInfos.intro">
            <a-input v-model:value="formData.intro" placeholder="请输入短介绍" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="长介绍" v-bind="validateInfos.summary">
	          <a-textarea v-model:value="formData.summary" rows="4" placeholder="请输入长介绍" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="总点击量" v-bind="validateInfos.totallyClickAmmount">
	          <a-input-number v-model:value="formData.totallyClickAmmount" placeholder="请输入总点击量" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="月点击量" v-bind="validateInfos.monthlyClickAmmount">
	          <a-input-number v-model:value="formData.monthlyClickAmmount" placeholder="请输入月点击量" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="周点击量" v-bind="validateInfos.weeklyClickAmmount">
	          <a-input-number v-model:value="formData.weeklyClickAmmount" placeholder="请输入周点击量" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="日点击量" v-bind="validateInfos.dailyClickAmmount">
	          <a-input-number v-model:value="formData.dailyClickAmmount" placeholder="请输入日点击量" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="收藏量" v-bind="validateInfos.collectionAmmount">
	          <a-input-number v-model:value="formData.collectionAmmount" placeholder="请输入收藏量" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="是否付费" v-bind="validateInfos.isNeedPay">
	          <j-switch v-model:value="formData.isNeedPay" :options="[1,0]" :disabled="disabled"></j-switch>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="打赏金额" v-bind="validateInfos.rewardAmmount">
	          <a-input-number v-model:value="formData.rewardAmmount" placeholder="请输入打赏金额" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="是否被锁定" v-bind="validateInfos.isLocked">
	          <j-switch v-model:value="formData.isLocked" :options="[1,0]" :disabled="disabled"></j-switch>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="采集来源标识符" v-bind="validateInfos.crawlOriginIdentity">
            <a-input v-model:value="formData.crawlOriginIdentity" placeholder="请输入采集来源标识符" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="审核时间" v-bind="validateInfos.examineTime">
		        <a-date-picker placeholder="请选择审核时间"  v-model:value="formData.examineTime" showTime value-format="YYYY-MM-DD HH:mm:ss" style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="审核原因" v-bind="validateInfos.examineReason">
            <a-input v-model:value="formData.examineReason" placeholder="请输入审核原因" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label="审核状态" v-bind="validateInfos.examineStatus">
	          <j-dict-select-tag v-model:value="formData.examineStatus" dictCode="mxy_examine_status" placeholder="请选择审核状态" :disabled="disabled"/>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>

		<!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey">
      <a-tab-pane tab="漫画章节列表" key="mxyComicChapter" :forceRender="true">
        <j-vxe-table
          :keep-source="true"
          ref="mxyComicChapterTableRef"
          :loading="mxyComicChapterTable.loading"
          :columns="mxyComicChapterTable.columns"
          :dataSource="mxyComicChapterTable.dataSource"
          :maxHeight="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"/>
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script lang="ts">
  import { defineComponent, ref, reactive, computed, toRaw } from 'vue';
  import { useValidateAntFormAndTable } from '/@/hooks/system/useJvxeMethods';
  import { queryMxyComicChapterListByMainId, queryDataById, saveOrUpdate } from '../MxyComic.api';
  import { JVxeTable } from '/@/components/jeecg/JVxeTable';
  import {mxyComicChapterColumns} from '../MxyComic.data';
  import JDictSelectTag from '/@/components/Form/src/jeecg/components/JDictSelectTag.vue';
  import JSwitch from '/@/components/Form/src/jeecg/components/JSwitch.vue';
  import JSelectUserByDept from '/@/components/Form/src/jeecg/components/JSelectUserByDept.vue';
  import JTreeSelect from '/@/components/Form/src/jeecg/components/JTreeSelect.vue';
  import JImageUpload from '/@/components/Form/src/jeecg/components/JImageUpload.vue';
  import { Form } from 'ant-design-vue';
  const useForm = Form.useForm;

  export default defineComponent({
    name: "MxyComicForm",
    components:{
      JDictSelectTag,
      JSwitch,
      JSelectUserByDept,
      JTreeSelect,
      JImageUpload,
      JVxeTable,
    },
    props:{
      disabled:{
        type: Boolean,
        default: false
      }
    },
    emits:['success'],
    setup(props, {emit}) {
      const loading = ref(false);
      const mxyComicChapterTableRef = ref();
      const mxyComicChapterTable = reactive<Record<string, any>>({
        loading: false,
        columns: mxyComicChapterColumns,
        dataSource: []
      });
      const activeKey = ref('mxyComicChapter');
      const formData = reactive<Record<string, any>>({
        id: '',
        name: '',
        nameEng: '',
        categoryId: '',
        isRecommend: '',
        coverVertical: '',
        coverHorizontal: '',
        updateStatus: '',
        authorId: '',
        authorName: '',
        notice: '',
        characterAuthor: '',
        picAuthor: '',
        intro: '',
        summary: '',
        totallyClickAmmount: '',
        monthlyClickAmmount: '',
        weeklyClickAmmount: '',
        dailyClickAmmount: '',
        collectionAmmount: '',
        isNeedPay: '',
        rewardAmmount: '',
        isLocked: '',
        crawlOriginIdentity: '',
        examineTime: '',
        examineReason: '',
        examineStatus: '',
      });

      //表单验证
      const validatorRules = reactive({
        name: [{ required: true, message: '请输入漫画名!'},],
        nameEng: [{ required: true, message: '请输入英文名!'},],
        categoryId: [{ required: true, message: '请输入所属分类!'},],
        coverVertical: [{ required: true, message: '请输入竖封面!'},],
        coverHorizontal: [{ required: true, message: '请输入横封面!'},],
        updateStatus: [{ required: true, message: '请输入更新状态!'},],
        characterAuthor: [{ required: true, message: '请输入文作者!'},],
        picAuthor: [{ required: true, message: '请输入图作者!'},],
      });
      const {resetFields, validate, validateInfos} = useForm(formData, validatorRules, {immediate: true});
      const dbData = {};
      const formItemLayout = {
        labelCol: {xs: {span: 24}, sm: {span: 5}},
        wrapperCol: {xs: {span: 24}, sm: {span: 16}},
      };

      const formDisabled = computed(() => {
        return props.disabled;
      });

      function add() {
        resetFields();
        mxyComicChapterTable.dataSource = [];
      }

      async function edit(row) {
        //主表数据
        await queryMainData(row.id);
        //子表数据
        const mxyComicChapterDataList = await queryMxyComicChapterListByMainId(row['id']);
        mxyComicChapterTable.dataSource = [...mxyComicChapterDataList];
      }

      async function queryMainData(id) {
        const row = await queryDataById(id);
        Object.keys(row).map(k => {
          formData[k] = row[k];
        });
      }

      const {getSubFormAndTableData, transformData} = useValidateAntFormAndTable(activeKey, {
        'mxyComicChapter': mxyComicChapterTableRef,
      });

      async function getFormData() {
        await validate();
        return transformData(toRaw(formData))
      }

      async function submitForm() {
        const mainData = await getFormData();
        const subData = await getSubFormAndTableData();
        const values = Object.assign({}, dbData, mainData, subData);
        console.log('表单提交数据', values)
        const isUpdate = values.id ? true : false
        await saveOrUpdate(values, isUpdate);
        //关闭弹窗
        emit('success');
      }
      
      function setFieldsValue(values) {
        if(values){
          Object.keys(values).map(k=>{
            formData[k] = values[k];
          });
        }
      }

      /**
       * 值改变事件触发-树控件回调
       * @param key
       * @param value
       */
      function handleFormChange(key, value) {
        formData[key] = value;
      }


      return {
        mxyComicChapterTableRef,
        mxyComicChapterTable,
        validatorRules,
        validateInfos,
        activeKey,
        loading,
        formData,
        setFieldsValue,
        handleFormChange,
        formItemLayout,
        formDisabled,
        getFormData,
        submitForm,
        add,
        edit
      }
    }
  });
</script>