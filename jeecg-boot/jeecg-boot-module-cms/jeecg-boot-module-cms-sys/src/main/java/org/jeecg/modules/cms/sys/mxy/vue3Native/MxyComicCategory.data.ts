import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '英文分类名',
    align: 'center',
    dataIndex: 'nameEng'
  },
  {
    title: '分类名',
    align: 'left',
    dataIndex: 'name'
  },
  {
    title: '排序优先级',
    align: 'center',
    dataIndex: 'sort'
  },
];

//查询数据
export const searchFormSchema: FormSchema[] = [
  {
    label: "英文分类名",
    field: "nameEng",
    component: 'Input',
    colProps: {span: 6},
  },
  {
    label: "分类名",
    field: "name",
    component: 'Input',
    colProps: {span: 6},
  },
];

//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '英文分类名',
    field: 'nameEng',
    component: 'Input',
  },
  {
    label: '分类名',
    field: 'name',
    component: 'Input',
  },
  {
    label: '排序优先级',
    field: 'sort',
    component: 'InputNumber',
  },
  {
    label: '父级节点',
    field: 'pid',
    component: 'JTreeSelect',
    componentProps: {
      dict: "mxy_comic_category,name,id",
      pidField: "pid",
      pidValue: "0",
      hasChildField: "has_child",
    },
  },
	// TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];
