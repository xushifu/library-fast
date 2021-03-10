<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()"
             label-width="80px">
      <el-form-item label="图书名称" prop="bookname">
        <el-input v-model="dataForm.bookname" placeholder="图书名称"></el-input>
      </el-form-item>
      <el-form-item label="ISBN码" prop="isbn">
        <el-input v-model="dataForm.isbn" placeholder="ISBN码"></el-input>
      </el-form-item>
      <el-form-item label="作者" prop="author">
        <el-input v-model="dataForm.author" placeholder="作者"></el-input>
      </el-form-item>
      <el-form-item label="分类" prop="classification">
        <el-select v-model="dataForm.classification"
                   clearable
                   placeholder="分类">
          <el-option v-for="item in classifications"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="译者" prop="translator">
        <el-input v-model="dataForm.translator" placeholder="译者"></el-input>
      </el-form-item>
      <el-form-item label="图书单价" prop="price">
        <el-input v-model="dataForm.price" placeholder="图书单价"></el-input>
      </el-form-item>
      <el-form-item label="出版社" prop="publishername">
        <el-input v-model="dataForm.publishername" placeholder="出版社"></el-input>
      </el-form-item>
      <el-form-item label="页数" prop="pages">
        <el-input v-model="dataForm.pages" placeholder="页数"></el-input>
      </el-form-item>
      <el-form-item label="字数" prop="words">
        <el-input v-model="dataForm.words" placeholder="字数"></el-input>
      </el-form-item>
      <el-form-item label="存放位置" prop="locationname">
        <el-input v-model="dataForm.locationname" placeholder="存放位置"></el-input>
      </el-form-item>
      <el-form-item label="版次" prop="edition">
        <el-input v-model="dataForm.edition" placeholder="版次"></el-input>
      </el-form-item>
      <el-form-item label="简介" prop="brief">
        <el-input v-model="dataForm.brief" placeholder="简介"></el-input>
      </el-form-item>
      <el-form-item label="语言" prop="language">
        <el-radio-group v-model="dataForm.language">
          <el-radio :label="0">中文</el-radio>
          <el-radio :label="1">英文</el-radio>
        </el-radio-group>
      </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data() {
      return {
        visible: false,
        dataForm: {
          bookId: 0,
          bookname: '',
          isbn: '',
          author: '',
          classification: '',
          translator: '',
          price: '',
          totalnumber: '',
          leftnumber: '',
          publishername: '',
          pages: '',
          words: '',
          locationname: '',
          edition: '',
          brief: '',
          language: '',
          createUserId: '',
          createUserName: '',
          createTime: ''
        },
        dataRule: {
          bookname: [
            {required: true, message: '图书名称不能为空', trigger: 'blur'}
          ],
          isbn: [
            {required: true, message: 'ISBN码不能为空', trigger: 'blur'}
          ],
          author: [
            {required: true, message: '作者不能为空', trigger: 'blur'}
          ],
          classification: [
            {required: true, message: '分类不能为空', trigger: 'blur'}
          ],
          publishername: [
            {required: true, message: '出版社不能为空', trigger: 'blur'}
          ],
          locationname: [
            {required: true, message: '存放位置不能为空', trigger: 'blur'}
          ],
          edition: [
            {required: true, message: '版次不能为空', trigger: 'blur'}
          ],
          brief: [
            {required: true, message: '简介不能为空', trigger: 'blur'}
          ]
        },
        classifications: [{
          value: 'B',
          label: '哲学'
        }, {
          value: 'I',
          label: '文学'
        }, {
          value: 'S',
          label: '农业科学'
        }]
      }
    },
    methods: {
      init(id) {
        this.dataForm.bookId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.bookId) {
            this.$http({
              url: this.$http.adornUrl(`/library/book/info/${this.dataForm.bookId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.bookname = data.book.bookname
                this.dataForm.isbn = data.book.isbn
                this.dataForm.author = data.book.author
                this.dataForm.classification = data.book.classification
                this.dataForm.translator = data.book.translator
                this.dataForm.price = data.book.price
                this.dataForm.totalnumber = data.book.totalnumber
                this.dataForm.leftnumber = data.book.leftnumber
                this.dataForm.publishername = data.book.publishername
                this.dataForm.pages = data.book.pages
                this.dataForm.words = data.book.words
                this.dataForm.locationname = data.book.locationname
                this.dataForm.edition = data.book.edition
                this.dataForm.brief = data.book.brief
                this.dataForm.language = data.book.language
                this.dataForm.createUserId = data.book.createUserId
                this.dataForm.createUserName = data.book.createUserName
                this.dataForm.createTime = data.book.createTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit() {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/library/book/${!this.dataForm.bookId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'bookId': this.dataForm.bookId || undefined,
                'bookname': this.dataForm.bookname,
                'isbn': this.dataForm.isbn,
                'author': this.dataForm.author,
                'classification': this.dataForm.classification,
                'translator': this.dataForm.translator,
                'price': this.dataForm.price,
                'totalnumber': this.dataForm.totalnumber,
                'leftnumber': this.dataForm.leftnumber,
                'publishername': this.dataForm.publishername,
                'pages': this.dataForm.pages,
                'words': this.dataForm.words,
                'locationname': this.dataForm.locationname,
                'edition': this.dataForm.edition,
                'brief': this.dataForm.brief,
                'language': this.dataForm.language,
                'createUserId': this.dataForm.createUserId,
                'createUserName': this.dataForm.createUserName,
                'createTime': this.dataForm.createTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
