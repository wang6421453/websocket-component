<template>
    <div class="container">

      <div class="page-content">
        <div class="search-form">
          <el-form v-model="msgForm" :inline="true">
            <el-form-item label="">
              <el-input
                placeholder="请输入消息"
                v-model="msgForm.msg"
                :clearable="true"
                size="40"
              >
              </el-input>
              <el-input
                placeholder="接收消息"
                v-model="msgForm.result"
                :clearable="true"
                size="40"
              >
              </el-input>
            </el-form-item>
            <el-form-item class="search-form-buttons">
              <el-button type="primary" @click="sendMsg">发送</el-button>
              <el-button @click="resetSearchForm">重置</el-button>
            </el-form-item>
          </el-form>
        </div>
        </div>
    </div>
</template>
        <script type="text/ecmascript-6">
         //import ws from '../services/socket';
          export default{
                data(){
                  return{
                    websocketUrl : "ws://localhost:8080/wl/websocket",
                    ws : null,
                    //查询表单
                    msgForm:{
                      msg:'',
                      result:''
                    }
                  }
                },
                methods: {
                    initWebSocket(){
                      this.ws = new WebSocket(this.websocketUrl);
                      this.ws.onopen = this.onOpen;
                      this.ws.onmessage = this.onMessage;
                      this.ws.onclose = this.onClose;
                    },
                    sendMsg(){
                      this.ws.send(this.msgForm.msg);
                    },
                    onOpen(evt){
                      console.log("Connection open ...");
                      //ws.send("Hello WebSockets!");
                    },
                    onMessage(evt){
                      console.log( "Received Message: " + evt.data);
                      this.msgForm.result = evt.data;
                    },
                    onClose(evt) {
                      console.log("Connection closed.");
                    }
                },
                mounted(){
                  this.initWebSocket();
                }
          }
        </script>

