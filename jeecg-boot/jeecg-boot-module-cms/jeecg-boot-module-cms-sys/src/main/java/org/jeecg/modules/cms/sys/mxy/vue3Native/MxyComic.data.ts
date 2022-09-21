import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '漫画名',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '所属分类',
    align:"center",
    dataIndex: 'categoryId_dictText'
   },
   {
    title: '是否推荐',
    align:"center",
    dataIndex: 'isRecommend',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'1'},{text:'否',value:'0'}])
     },
   },
   {
    title: '横封面',
    align:"center",
    dataIndex: 'coverHorizontal',
    customRender:render.renderImage,
   },
   {
    title: '作者账号',
    align:"center",
    dataIndex: 'authorId_dictText'
   },
   {
    title: '作者名称',
    align:"center",
    dataIndex: 'authorName'
   },
   {
    title: '总点击量',
    align:"center",
    sorter: true,
    dataIndex: 'totallyClickAmmount'
   },
   {
    title: '日点击量',
    align:"center",
    sorter: true,
    dataIndex: 'dailyClickAmmount'
   },
   {
    title: '收藏量',
    align:"center",
    sorter: true,
    dataIndex: 'collectionAmmount'
   },
   {
    title: '是否付费',
    align:"center",
    dataIndex: 'isNeedPay',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'1'},{text:'否',value:'0'}])
     },
   },
   {
    title: '是否被锁定',
    align:"center",
    dataIndex: 'isLocked',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'1'},{text:'否',value:'0'}])
     },
   },
   {
    title: '审核状态',
    align:"center",
    dataIndex: 'examineStatus_dictText'
   },
   {
    title: '更新日期',
    align:"center",
    sorter: true,
    dataIndex: 'updateTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "漫画名",
      field: "name",
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "所属分类",
      field: "categoryId",
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "是否推荐",
      field: "isRecommend",
      component: 'JSwitch',
      componentProps:{
           options:"[1,0]"
       },
      colProps: {span: 6},
 	},
	{
      label: "更新状态",
      field: "updateStatus",
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"mxy_update_status"
      },
      colProps: {span: 6},
 	},
	{
      label: "作者账号",
      field: "authorId",
      component: 'JSelectUserByDept',
      colProps: {span: 6},
 	},
	{
      label: "作者名称",
      field: "authorName",
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "文作者",
      field: "characterAuthor",
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "图作者",
      field: "picAuthor",
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "是否付费",
      field: "isNeedPay",
      component: 'JSwitch',
      componentProps:{
           options:"[1,0]"
       },
      colProps: {span: 6},
 	},
	{
      label: "是否被锁定",
      field: "isLocked",
      component: 'JSwitch',
      componentProps:{
           options:"[1,0]"
       },
      colProps: {span: 6},
 	},
	{
      label: "采集来源标识符",
      field: "crawlOriginIdentity",
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "审核状态",
      field: "examineStatus",
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"mxy_examine_status"
      },
      colProps: {span: 6},
 	},
	{
      label: "创建日期",
      field: "createTime",
      component: 'DatePicker',
      componentProps: {
         showTime:true,
         valueFormat: 'YYYY-MM-DD HH:mm:ss'
       },
      colProps: {span: 6},
 	},
	{
      label: "更新日期",
      field: "updateTime",
      component: 'DatePicker',
      componentProps: {
         showTime:true,
         valueFormat: 'YYYY-MM-DD HH:mm:ss'
       },
      colProps: {span: 6},
 	},
	{
      label: "删除日期",
      field: "deleteTime",
      component: 'DatePicker',
      componentProps: {
         showTime:true,
         valueFormat: 'YYYY-MM-DD HH:mm:ss'
       },
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '漫画名',
    field: 'name',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入漫画名!'},
          ];
     },
  },
  {
    label: '英文名',
    field: 'nameEng',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入英文名!'},
          ];
     },
  },
  {
    label: '所属分类',
    field: 'categoryId',
    component: 'JTreeSelect',
    componentProps:{
        dict:"mxy_comic_category,name,id",
        pidValue:"0",
    },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入所属分类!'},
          ];
     },
  },
  {
    label: '是否推荐',
    field: 'isRecommend',
     component: 'JSwitch',
     componentProps:{
         options:[1,0]
     },
  },
  {
    label: '竖封面',
    field: 'coverVertical',
     component: 'JImageUpload',
     componentProps:{
        fileMax:1
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入竖封面!'},
          ];
     },
  },
  {
    label: '横封面',
    field: 'coverHorizontal',
     component: 'JImageUpload',
     componentProps:{
        fileMax:1
      },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入横封面!'},
          ];
     },
  },
  {
    label: '更新状态',
    field: 'updateStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"mxy_update_status"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入更新状态!'},
          ];
     },
  },
  {
    label: '作者账号',
    field: 'authorId',
    component: 'JSelectUserByDept',
    componentProps:{
        labelKey:'realname',
     },
  },
  {
    label: '作者名称',
    field: 'authorName',
    component: 'Input',
  },
  {
    label: '公告',
    field: 'notice',
    component: 'InputTextArea',
  },
  {
    label: '文作者',
    field: 'characterAuthor',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入文作者!'},
          ];
     },
  },
  {
    label: '图作者',
    field: 'picAuthor',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入图作者!'},
          ];
     },
  },
  {
    label: '短介绍',
    field: 'intro',
    component: 'Input',
  },
  {
    label: '长介绍',
    field: 'summary',
    component: 'InputTextArea',
  },
  {
    label: '总点击量',
    field: 'totallyClickAmmount',
    component: 'InputNumber',
  },
  {
    label: '月点击量',
    field: 'monthlyClickAmmount',
    component: 'InputNumber',
  },
  {
    label: '周点击量',
    field: 'weeklyClickAmmount',
    component: 'InputNumber',
  },
  {
    label: '日点击量',
    field: 'dailyClickAmmount',
    component: 'InputNumber',
  },
  {
    label: '收藏量',
    field: 'collectionAmmount',
    component: 'InputNumber',
  },
  {
    label: '是否付费',
    field: 'isNeedPay',
     component: 'JSwitch',
     componentProps:{
         options:[1,0]
     },
  },
  {
    label: '打赏金额',
    field: 'rewardAmmount',
    component: 'InputNumber',
  },
  {
    label: '是否被锁定',
    field: 'isLocked',
     component: 'JSwitch',
     componentProps:{
         options:[1,0]
     },
  },
  {
    label: '采集来源标识符',
    field: 'crawlOriginIdentity',
    component: 'Input',
  },
  {
    label: '审核时间',
    field: 'examineTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '审核原因',
    field: 'examineReason',
    component: 'Input',
  },
  {
    label: '审核状态',
    field: 'examineStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"mxy_examine_status"
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
//子表单数据
//子表表格配置
export const mxyComicChapterColumns: JVxeColumn[] = [
    {
      title: '排序优先级',
      key: 'sort',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '标题',
      key: 'title',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '是否金币付费',
      key: 'isNeedCoin',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '审核状态',
      key: 'examineStatus',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:1,
    },
    {
      title: '审核原因',
      key: 'examineReason',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '是否VIP内容',
      key: 'isVip',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '采集来源唯一标识符',
      key: 'crawlOriginIdentity',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]
