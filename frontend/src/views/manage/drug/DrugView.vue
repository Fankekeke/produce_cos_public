<template>
  <a-modal v-model="show" title="农产品详情" @cancel="onClose" :width="800">
    <template slot="footer">
      <a-button key="back" @click="onClose" type="danger">
        关闭
      </a-button>
    </template>
    <div style="font-size: 13px;font-family: SimHei" v-if="drugData !== null">
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col style="margin-bottom: 15px"><span style="font-size: 15px;font-weight: 650;color: #000c17">农产品信息</span></a-col>
        <a-col :span="8"><b>农产品名称：</b>
          {{ drugData.name }}
        </a-col>
        <a-col :span="8"><b>农产品编号：</b>
          {{ drugData.code }}
        </a-col>
        <a-col :span="8"><b>所属品牌：</b>
          {{ drugData.brand }}
        </a-col>
      </a-row>
      <br/>
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col :span="8"><b>所属分类：</b>
          <span v-if="drugData.category == 1">植物类</span>
          <span v-if="drugData.category == 2">畜禽类</span>
          <span v-if="drugData.category == 3">水产类</span>
        </a-col>
        <a-col :span="8"><b>农产品类别：</b>
          <span v-if="drugData.classification == 1">粮食</span>
          <span v-if="drugData.classification == 2">蔬菜</span>
          <span v-if="drugData.classification == 3">水果</span>
          <span v-if="drugData.classification == 4">养殖</span>
          <span v-if="drugData.classification == 5">其他</span>
        </a-col>
        <a-col :span="8"><b>通用名：</b>
          {{ drugData.commonName }}
        </a-col>
      </a-row>
      <br/>
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col :span="8"><b>品种：</b>
          {{ drugData.dosageForm }}
        </a-col>
        <a-col :span="16"><b>特产品类：</b>
          {{ drugData.usages }}
        </a-col>
        <br/>
        <br/>
        <a-col :span="24"><b>贮存条件：</b>
          {{ drugData.applicableSymptoms }}
        </a-col>
      </a-row>
      <br/>
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col :span="24"><b>原产地：</b>
          {{ drugData.applicableDisease }}
        </a-col>
        <br/>
        <br/>
        <a-col :span="8"><b>包装清单：</b>
          {{ drugData.packingList }}
        </a-col>
        <a-col :span="16"><b>包装形式：</b>
          {{ drugData.dosageUse }}
        </a-col>
      </a-row>
      <br/>
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col :span="8"><b>有效期：</b>
          {{ drugData.validityPeriod }} 月
        </a-col>
        <a-col :span="8"><b>批准文号：</b>
          {{ drugData.approvalNumber }}
        </a-col>
        <a-col :span="8"><b>国产/进口：</b>
          {{ drugData.manufacturer }}
        </a-col>
      </a-row>
      <br/>
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col :span="8"><b>单价：</b>
          {{ drugData.unitPrice }} 元
        </a-col>
        <a-col :span="8"><b>创建时间：</b>
          {{ drugData.createDate }}
        </a-col>
      </a-row>
      <br/>
      <a-row style="padding-left: 24px;padding-right: 24px;">
        <a-col style="margin-bottom: 15px"><span style="font-size: 15px;font-weight: 650;color: #000c17">农产品图片</span></a-col>
        <a-col :span="24">
          <a-upload
            name="avatar"
            action="http://127.0.0.1:9527/file/fileUpload/"
            list-type="picture-card"
            :file-list="fileList"
            @preview="handlePreview"
            @change="picHandleChange"
          >
          </a-upload>
          <a-modal :visible="previewVisible" :footer="null" @cancel="handleCancel">
            <img alt="example" style="width: 100%" :src="previewImage" />
          </a-modal>
        </a-col>
      </a-row>
      <br/>
      <br/>
    </div>
  </a-modal>
</template>

<script>
import moment from 'moment'
moment.locale('zh-cn')
function getBase64 (file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader()
    reader.readAsDataURL(file)
    reader.onload = () => resolve(reader.result)
    reader.onerror = error => reject(error)
  })
}
export default {
  name: 'drugView',
  props: {
    drugShow: {
      type: Boolean,
      default: false
    },
    drugData: {
      type: Object
    }
  },
  computed: {
    show: {
      get: function () {
        return this.drugShow
      },
      set: function () {
      }
    }
  },
  data () {
    return {
      loading: false,
      fileList: [],
      previewVisible: false,
      previewImage: ''
    }
  },
  watch: {
    drugShow: function (value) {
      if (value) {
        if (this.drugData.images !== null && this.drugData.images !== '') {
          this.imagesInit(this.drugData.images)
        }
      }
    }
  },
  methods: {
    imagesInit (images) {
      if (images !== null && images !== '') {
        let imageList = []
        images.split(',').forEach((image, index) => {
          imageList.push({uid: index, name: image, status: 'done', url: 'http://127.0.0.1:9527/imagesWeb/' + image})
        })
        this.fileList = imageList
      }
    },
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
    onClose () {
      this.$emit('close')
    }
  }
}
</script>

<style scoped>

</style>
