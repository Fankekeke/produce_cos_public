### 基于SpringBoot + Vue的农产品销售系统

生鲜农产品销售系统、农村电商管理系统、农产品在线交易系统

#### 管理员功能模块介绍：
###### 公告管理：发布平台通知、促销活动或农产品供应信息。产品管理：维护农产品基本信息，包括名称、规格、产地等。库存统计：汇总各销售店及库房的农产品实时库存数据。物流信息：跟踪农产品从仓库到用户的配送与运输状态。订单详情：查看每笔订单的商品、数量、价格及履约进度。订单评价：浏览用户对农产品质量与服务的评分和留言。订单信息：统一管理所有用户提交的农产品购买订单。缴费记录：查询用户支付订单的金额、时间及支付方式。销售店管理：维护线下或合作销售网点的基本信息与状态。产店库存：监控各销售店的农产品库存数量与周转情况。员工管理：管理平台及门店工作人员账号与岗位权限。用户管理：查看和维护注册用户资料及账户状态。数据统计：分析用户行为、订单量、访问量等运营指标。销售排行：生成热销农产品或销售店的排名榜单。员工统计：统计员工绩效、处理订单数或服务评价数据。管理员管理：配置后台管理员账号及操作权限分级。供应采购：制定农产品采购计划并发起采购流程。供应商管理：维护合作农户或合作社的资质与供货信息。产品答疑：审核并回复用户关于农产品的咨询问题。产品采购：执行具体农产品的采购下单与合同管理。库房预警：自动提醒库存不足或临近过期的农产品。销售统计：按日/月/年生成销售额、销量等分析报表。采购物流：跟踪采购农产品从供应商到仓库的运输过程。

#### 用户功能模块介绍：
###### 我的信息：集中展示个人账户概览及常用功能入口。个人信息：编辑姓名、联系方式、收货地址等资料。我的订单：查看历史及当前农产品订单状态与物流信息。缴费记录：查阅已完成支付的订单费用及支付凭证。订单评价：对已收货的农产品进行质量评分与文字评价。产品购买：浏览农产品目录，选择商品并提交购买订单。支付结果：显示支付成功或失败状态，并提供订单确认。

#### 安装环境

JAVA 环境 

Node.js环境 [https://nodejs.org/en/] 选择14.17

Yarn 打开cmd， 输入npm install -g yarn !!!必须安装完毕nodejs 

Mysql 数据库 [https://blog.csdn.net/qq_40303031/article/details/88935262] 一定要把账户和密码记住

redis 

Idea 编译器 [https://blog.csdn.net/weixin_44505194/article/details/104452880]

WebStorm OR VScode 编译器 [https://www.jianshu.com/p/d63b5bae9dff]

#### 采用技术及功能

后端：SpringBoot、MybatisPlus、MySQL、Redis、
前端：Vue、Apex、Antd、Axios、baidu.js


平台后台：springboot(框架) + redis(缓存中间件) + shiro(权限中间件) + mybatisplus(orm) + restful风格接口 + mysql(数据库)

开发环境：windows10 or windows7 ， vscode or webstorm ， idea + lambok

支付使用阿里沙盒支付

#### 前台启动方式

安装所需文件 yarn install 
运行 yarn run dev

#### 后端启动方式

1.首先启动redis，进入redis目录终端。输入redis-server回车
2.导入sql文件，修改数据库与redis连接配置
3.idea中启动后端项目

### 管理员
公告管理，产品管理，库存统计，物流信息，订单详情，订单评价，订单信息，缴费记录，销售店管理，产店库存，员工管理，用户管理，数据统计，销售排行，员工统计，管理员管理，供应采购，供应商管理，产品答疑，产品采购，库房预警，销售统计，产品答疑，采购物流

### 用户
我的信息，个人信息，我的订单，缴费记录，订单评价，产品购买，支付结果

#### 默认后台账户密码

[管理员]
admin
1234qwer

[用户]
fank
1234qwer

#### 项目截图

|  |  |
|---------------------|---------------------|
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395740336.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396234216.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395722465.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396225513.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433810791.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396214632.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433802190.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396206466.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433792323.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396197426.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433777545.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396188442.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433767672.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396180576.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433753406.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396169841.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734433741800.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395932079.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396280736.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395836533.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396268525.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395813055.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396254785.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395801760.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734396246018.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1734395750343.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/work/936e9baf53eb9a217af4f89c616dc19.png) |

#### 演示视频

暂无

#### 获取方式

Email: fan1ke2ke@gmail.com

WeChat: `Storm_Berserker`

`附带部署与讲解服务，因为要恰饭资源非免费，伸手党勿扰，谢谢理解😭`

> 1.项目纯原创，不做二手贩子 2.一次购买终身有效 3.项目讲解持续到答辩结束 4.非常负责的答辩指导 5.**黑奴价格**

> 项目部署调试不好包退！功能逻辑没讲明白包退！

#### 其它资源

[2025年-答辩顺利通过-客户评价🍜](https://berserker287.github.io/2025/06/18/2025%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2024年-答辩顺利通过-客户评价👻](https://berserker287.github.io/2024/06/06/2024%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2023年-答辩顺利通过-客户评价🐢](https://berserker287.github.io/2023/06/14/2023%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2022年-答辩通过率100%-客户评价🐣](https://berserker287.github.io/2022/05/25/%E9%A1%B9%E7%9B%AE%E4%BA%A4%E6%98%93%E8%AE%B0%E5%BD%95/)

[毕业答辩导师提问的高频问题](https://berserker287.github.io/2023/06/13/%E6%AF%95%E4%B8%9A%E7%AD%94%E8%BE%A9%E5%AF%BC%E5%B8%88%E6%8F%90%E9%97%AE%E7%9A%84%E9%AB%98%E9%A2%91%E9%97%AE%E9%A2%98/)

[50个高频答辩问题-技术篇](https://berserker287.github.io/2023/06/13/50%E4%B8%AA%E9%AB%98%E9%A2%91%E7%AD%94%E8%BE%A9%E9%97%AE%E9%A2%98-%E6%8A%80%E6%9C%AF%E7%AF%87/)

[计算机毕设答辩时都会问到哪些问题？](https://www.zhihu.com/question/31020988)

[计算机专业毕业答辩小tips](https://zhuanlan.zhihu.com/p/145911029)


#### 接JAVAWEB毕设，纯原创，价格公道，诚信第一

`网站建设、小程序、H5、APP、各种系统 选题+开题报告+任务书+程序定制+安装调试+项目讲解+论文+答辩PPT`

More info: [悲伤的橘子树](https://berserker287.github.io/)

<p><img align="center" src="https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/%E5%90%88%E4%BD%9C%E7%89%A9%E6%96%99%E6%A0%B7%E5%BC%8F%20(3).png" alt="fankekeke" /></p>
