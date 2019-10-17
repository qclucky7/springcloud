# springcloud

springcloud搭建练习，eureka集群,zuul网关,hystrix熔断机制以及监控,fegin访问。
springboot版本2.0.5 springcloud版本Finchley.SR1。

整合getaway做网关,sentinel做熔断,搭配sentienl控制台。用nacos做sentienl的动态数据源和springcloud的配置中心。
sentinel控制台下载1.6.3版本,本地起控制台java -jar sentinel-dashboard-1.6.3.jar
nacos下载到本地,启动命令官网有。

1.记录问题:
   (1) 从nacos拉取规则网关控制台不显示规则 更改配置  rule-type: gw-flow


