<template>
  <a-modal v-model="show" title="修改农产品" @cancel="onClose" :width="800">
    <template slot="footer">
      <a-button key="back" @click="onClose">
        取消
      </a-button>
      <a-button key="submit" type="primary" :loading="loading" @click="handleSubmit">
        修改
      </a-button>
    </template>
    <a-form :form="form" layout="vertical">
      <a-row :gutter="20">
        <a-col :span="6">
          <a-form-item label='农产品名称' v-bind="formItemLayout">
            <a-input v-decorator="[
            'name',
            { rules: [{ required: true, message: '请输入名称!' }] }
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label='品牌' v-bind="formItemLayout">
            <a-input v-decorator="[
            'brand',
            { rules: [{ required: true, message: '请输入品牌!' }] }
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label='所属分类' v-bind="formItemLayout">
            <a-select v-decorator="[
              'category',
              { rules: [{ required: true, message: '请输入所属分类!' }] }
              ]">
              <a-select-option value="1">植物类</a-select-option>
              <a-select-option value="2">畜禽类</a-select-option>
              <a-select-option value="3">水产类</a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label='农产品类别' v-bind="formItemLayout">
            <a-select v-decorator="[
              'classification',
              { rules: [{ required: true, message: '请输入农产品类别!' }] }
              ]">
              <a-select-option value="1">粮食 </a-select-option>
              <a-select-option value="2">蔬菜</a-select-option>
              <a-select-option value="3">水果</a-select-option>
              <a-select-option value="4">养殖</a-select-option>
              <a-select-option value="5">其他 </a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label='通用名' v-bind="formItemLayout">
            <a-input v-decorator="[
            'commonName'
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label='品种' v-bind="formItemLayout">
            <a-input v-decorator="[
            'dosageForm'
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="6">
          <a-form-item label='特产品类' v-bind="formItemLayout">
            <a-input v-decorator="[
            'usages'
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label='贮存条件' v-bind="formItemLayout">
            <a-input v-decorator="[
            'applicableSymptoms'
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label='原产地' v-bind="formItemLayout">
            <a-input v-decorator="[
            'applicableDisease'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="6">
          <a-form-item label='包装清单' v-bind="formItemLayout">
            <a-input v-decorator="[
            'packingList'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="6">
          <a-form-item label='包装形式' v-bind="formItemLayout">
            <a-input v-decorator="[
            'dosageUse'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="6">
          <a-form-item label='有效期' v-bind="formItemLayout">
            <a-input-number style="width: 100%" :min="1" :step="1" v-decorator="[
            'validityPeriod'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="6">
          <a-form-item label='批准文号' v-bind="formItemLayout">
            <a-input v-decorator="[
            'approvalNumber'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="6">
          <a-form-item label='国产/进口' v-bind="formItemLayout">
            <a-input v-decorator="[
            'manufacturer'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="6">
          <a-form-item label='单价' v-bind="formItemLayout">
            <a-input-number style="width: 100%" :min="1" :step="0.1" v-decorator="[
            'unitPrice'
            ]"/>
          </a-form-item
          >
        </a-col>
        <a-col :span="24">
          <a-form-item label='农产品图片' v-bind="formItemLayout">
            <a-upload
              name="avatar"
              action="http://127.0.0.1:9527/file/fileUpload/"
              list-type="picture-card"
              :file-list="fileList"
              @preview="handlePreview"
              @change="picHandleChange"
            >
              <div v-if="fileList.length < 8">
                <a-icon type="plus" />
                <div class="ant-upload-text">
                  Upload
                </div>
              </div>
            </a-upload>
            <a-modal :visible="previewVisible" :footer="null" @cancel="handleCancel">
              <img alt="example" style="width: 100%" :src="previewImage" />
            </a-modal>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
  </a-modal>
</template>

<script>
import {mapState} from 'vuex'
function getBase64 (file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader()
    reader.readAsDataURL(file)
    reader.onload = () => resolve(reader.result)
    reader.onerror = error => reject(error)
  })
}
const formItemLayout = {
  labelCol: { span: 24 },
  wrapperCol: { span: 24 }
}
export default {
  name: 'drugEdit',
  props: {
    drugEditVisiable: {
      default: false
    }
  },
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    }),
    show: {
      get: function () {
        return this.drugEditVisiable
      },
      set: function () {
      }
    }
  },
  data () {
    return {
      rowId: null,
      formItemLayout,
      form: this.$form.createForm(this),
      loading: false,
      fileList: [],
      previewVisible: false,
      previewImage: ''
    }
  },
  methods: {
    handleCancel () {
      this.previewVisible = false
    },
    async handlePreview (file) {
      if (!file.url && !file.preview) {
        file.preview = await getBase64(file.originFileObj)
      }
      this.previewImage = file.url || file.preview
      this.previewVisible = true
    },
    picHandleChange ({ fileList }) {
      this.fileList = fileList
    },
    imagesInit (images) {
      if (images !== null && images !== '') {
        let imageList = []
        images.split(',').forEach((image, index) => {
          imageList.push({uid: index, name: image, status: 'done', url: 'http://127.0.0.1:9527/imagesWeb/' + image})
        })
        this.fileList = imageList
      }
    },
    setFormValues ({...drug}) {
      this.rowId = drug.id
      let fields = ['name', 'brand', 'category', 'classification', 'commonName', 'dosageForm', 'usages', 'applicableSymptoms', 'applicableDisease', 'packingList', 'dosageUse', 'validityPeriod', 'approvalNumber', 'manufacturer', 'unitPrice', 'images']
      let obj = {}
      Object.keys(drug).forEach((key) => {
        if (key === 'images') {
          this.fileList = []
          this.imagesInit(drug['images'])
        }
        if (key === 'category' || key === 'classification') {
          drug[key] = drug[key].toString()
        }
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          obj[key] = drug[key]
        }
      })
      this.form.setFieldsValue(obj)
    },
    reset () {
      this.loading = false
      this.form.resetFields()
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
    handleSubmit () {
      // 获取图片List
      let images = []
      this.fileList.forEach(image => {
        if (image.response !== undefined) {
          images.push(image.response)
        } else {
          images.push(image.name)
        }
      })
      this.form.validateFields((err, values) => {
        values.id = this.rowId
        values.images = images.length > 0 ? images.join(',') : null
        if (!err) {
          this.loading = true
          this.$put('/cos/drug-info', {
            ...values
          }).then((r) => {
            this.reset()
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
