<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <!-- 主表单区域 -->
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="12" >
            <a-form-model-item label="漫画名" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="name">
              <a-input v-model="model.name" placeholder="请输入漫画名" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="英文名" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="nameEng">
              <a-input v-model="model.nameEng" placeholder="请输入英文名" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="所属分类" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="categoryId">
  	          <j-tree-select
                ref="treeSelect"
                placeholder="请选择所属分类"
                v-model="model.categoryId"
                dict="mxy_comic_category,name,id"
                pidValue="0"
                >
              </j-tree-select>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="是否推荐" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="isRecommend">
              <j-switch v-model="model.isRecommend" :options="[1,0]" ></j-switch>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="竖封面" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="coverVertical">
              <j-image-upload isMultiple :number=1 v-model="model.coverVertical" ></j-image-upload>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="横封面" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="coverHorizontal">
              <j-image-upload isMultiple :number=1 v-model="model.coverHorizontal" ></j-image-upload>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="更新状态" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="updateStatus">
              <j-dict-select-tag type="list" v-model="model.updateStatus" dictCode="mxy_update_status" placeholder="请选择更新状态" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="作者账号" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="authorId">
              <j-select-user-by-dep v-model="model.authorId" :multi="true" store="id" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="作者名称" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="authorName">
              <a-input v-model="model.authorName" placeholder="请输入作者名称" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="公告" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="notice">
              <a-textarea v-model="model.notice" rows="4" placeholder="请输入公告" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="文作者" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="characterAuthor">
              <a-input v-model="model.characterAuthor" placeholder="请输入文作者" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="图作者" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="picAuthor">
              <a-input v-model="model.picAuthor" placeholder="请输入图作者" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="短介绍" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="intro">
              <a-input v-model="model.intro" placeholder="请输入短介绍" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="长介绍" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="summary">
              <a-textarea v-model="model.summary" rows="4" placeholder="请输入长介绍" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="总点击量" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="totallyClickAmmount">
              <a-input-number v-model="model.totallyClickAmmount" placeholder="请输入总点击量" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="月点击量" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="monthlyClickAmmount">
              <a-input-number v-model="model.monthlyClickAmmount" placeholder="请输入月点击量" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="周点击量" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="weeklyClickAmmount">
              <a-input-number v-model="model.weeklyClickAmmount" placeholder="请输入周点击量" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="日点击量" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="dailyClickAmmount">
              <a-input-number v-model="model.dailyClickAmmount" placeholder="请输入日点击量" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="收藏量" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="collectionAmmount">
              <a-input-number v-model="model.collectionAmmount" placeholder="请输入收藏量" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="是否付费" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="isNeedPay">
              <j-switch v-model="model.isNeedPay" :options="[1,0]" ></j-switch>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="打赏金额" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rewardAmmount">
              <a-input-number v-model="model.rewardAmmount" placeholder="请输入打赏金额" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="是否被锁定" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="isLocked">
              <j-switch v-model="model.isLocked" :options="[1,0]" ></j-switch>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="采集来源标识符" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="crawlOriginIdentity">
              <a-input v-model="model.crawlOriginIdentity" placeholder="请输入采集来源标识符" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="审核时间" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="examineTime">
              <j-date placeholder="请选择审核时间" v-model="model.examineTime" :show-time="true" date-format="YYYY-MM-DD HH:mm:ss" style="width: 100%" />
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="审核原因" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="examineReason">
              <a-input v-model="model.examineReason" placeholder="请输入审核原因" ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="12" >
            <a-form-model-item label="审核状态" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="examineStatus">
              <j-dict-select-tag type="list" v-model="model.examineStatus" dictCode="mxy_examine_status" placeholder="请选择审核状态" />
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </j-form-container>
      <!-- 子表单区域 -->
    <a-tabs v-model="activeKey" @change="handleChangeTabs">
      <a-tab-pane tab="漫画章节列表" :key="refKeys[0]" :forceRender="true">
        <j-vxe-table
          keep-source
          :ref="refKeys[0]"
          :loading="mxyComicChapterTable.loading"
          :columns="mxyComicChapterTable.columns"
          :dataSource="mxyComicChapterTable.dataSource"
          :maxHeight="300"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"
          />
      </a-tab-pane>
    </a-tabs>
  </a-spin>
</template>

<script>

  import { getAction } from '@/api/manage'
  import { JVxeTableModelMixin } from '@/mixins/JVxeTableModelMixin.js'
  import { JVXETypes } from '@/components/jeecg/JVxeTable'
  import { getRefPromise,VALIDATE_FAILED} from '@/components/jeecg/JVxeTable/utils/vxeUtils.js'
  import { validateDuplicateValue } from '@/utils/util'
  import JFormContainer from '@/components/jeecg/JFormContainer'

  export default {
    name: 'MxyComicForm',
    mixins: [JVxeTableModelMixin],
    components: {
      JFormContainer,
    },
    data() {
      return {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        model:{
            examineStatus:1,
         },
        // 新增时子表默认添加几行空数据
        addDefaultRowNum: 1,
        validatorRules: {
           name: [
              { required: true, message: '请输入漫画名!'},
           ],
           nameEng: [
              { required: true, message: '请输入英文名!'},
           ],
           categoryId: [
              { required: true, message: '请输入所属分类!'},
           ],
           coverVertical: [
              { required: true, message: '请输入竖封面!'},
           ],
           coverHorizontal: [
              { required: true, message: '请输入横封面!'},
           ],
           updateStatus: [
              { required: true, message: '请输入更新状态!'},
           ],
           characterAuthor: [
              { required: true, message: '请输入文作者!'},
           ],
           picAuthor: [
              { required: true, message: '请输入图作者!'},
           ],
        },
        refKeys: ['mxyComicChapter', ],
        tableKeys:['mxyComicChapter', ],
        activeKey: 'mxyComicChapter',
        // 漫画章节列表
        mxyComicChapterTable: {
          loading: false,
          dataSource: [],
          columns: [
            {
              title: '排序优先级',
              key: 'sort',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '标题',
              key: 'title',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '是否金币付费',
              key: 'isNeedCoin',
              type: JVXETypes.checkbox,
                customValue: [1,0],
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '审核状态',
              key: 'examineStatus',
              type: JVXETypes.select,
              options:[],
              dictCode:"mxy_examine_status",
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:1,
            },
            {
              title: '审核原因',
              key: 'examineReason',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '是否VIP内容',
              key: 'isVip',
              type: JVXETypes.checkbox,
                customValue: [1,0],
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
            {
              title: '采集来源唯一标识符',
              key: 'crawlOriginIdentity',
               type: JVXETypes.input,
              width:"200px",
              placeholder: '请输入${title}',
              defaultValue:'',
            },
          ]
        },
        url: {
          add: "/mxy/mxyComic/add",
          edit: "/mxy/mxyComic/edit",
          queryById: "/mxy/mxyComic/queryById",
          mxyComicChapter: {
            list: '/mxy/mxyComic/queryMxyComicChapterByMainId'
          },
        }
      }
    },
    props: {
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    computed: {
      formDisabled(){
        return this.disabled
      },
    },
    created () {
    },
    methods: {
      addBefore(){
        this.mxyComicChapterTable.dataSource=[]
      },
      getAllTable() {
        let values = this.tableKeys.map(key => getRefPromise(this, key))
        return Promise.all(values)
      },
      /** 调用完edit()方法之后会自动调用此方法 */
      editAfter() {
        this.$nextTick(() => {
        })
        // 加载子表数据
        if (this.model.id) {
          let params = { id: this.model.id }
          this.requestSubTableData(this.url.mxyComicChapter.list, params, this.mxyComicChapterTable)
        }
      },
      //校验所有一对一子表表单
        validateSubForm(allValues){
            return new Promise((resolve,reject)=>{
              Promise.all([
              ]).then(() => {
                resolve(allValues)
              }).catch(e => {
                if (e.error === VALIDATE_FAILED) {
                  // 如果有未通过表单验证的子表，就自动跳转到它所在的tab
                  this.activeKey = e.index == null ? this.activeKey : this.refKeys[e.index]
                } else {
                  console.error(e)
                }
              })
            })
        },
      /** 整理成formData */
      classifyIntoFormData(allValues) {
        let main = Object.assign(this.model, allValues.formValue)
        return {
          ...main, // 展开
          mxyComicChapterList: allValues.tablesValue[0].tableData,
        }
      },
      validateError(msg){
        this.$message.error(msg)
      },

    }
  }
</script>

<style scoped>
</style>