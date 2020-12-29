/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.17 : Database - tp_travel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tp_travel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tp_travel`;

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `lr_id` int(11) NOT NULL AUTO_INCREMENT,
  `lr_name` varchar(100) DEFAULT NULL,
  `lr_date` varchar(100) DEFAULT NULL,
  `lr_content` varchar(100) DEFAULT NULL,
  `lr_for_name` varchar(100) DEFAULT NULL,
  `lr_for_words` varchar(100) DEFAULT NULL,
  `lr_for_reply` varchar(100) DEFAULT NULL,
  `lr_for_article_id` varchar(100) DEFAULT NULL,
  `lr_forumId` varchar(100) DEFAULT NULL,
  `lr_hotel_id` varchar(100) DEFAULT NULL,
  `lr_food_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

/*Table structure for table `tp_admin` */

DROP TABLE IF EXISTS `tp_admin`;

CREATE TABLE `tp_admin` (
  `tp_aid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_aname` varchar(100) DEFAULT NULL,
  `tp_aemail` varchar(100) DEFAULT NULL,
  `tp_apwd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tp_aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tp_admin` */

insert  into `tp_admin`(`tp_aid`,`tp_aname`,`tp_aemail`,`tp_apwd`) values (1,'root','root@qq.com','root'),(2,'admin','admin@qq.com','admin');

/*Table structure for table `tp_food` */

DROP TABLE IF EXISTS `tp_food`;

CREATE TABLE `tp_food` (
  `tp_fid` int(30) NOT NULL AUTO_INCREMENT,
  `tp_ftitle` varchar(100) DEFAULT NULL,
  `tp_fname` varchar(100) DEFAULT NULL,
  `tp_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tp_fpic` varchar(100) DEFAULT NULL,
  `tp_fprice` int(30) DEFAULT NULL,
  `tp_fcontent` text,
  `tp_phone` varchar(30) DEFAULT NULL,
  `tp_fcreated` datetime NOT NULL,
  PRIMARY KEY (`tp_fid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tp_food` */

insert  into `tp_food`(`tp_fid`,`tp_ftitle`,`tp_fname`,`tp_address`,`tp_fpic`,`tp_fprice`,`tp_fcontent`,`tp_phone`,`tp_fcreated`) values (12,'南昌米粉真好吃','南昌米粉','南昌','04b0decf-4493-4877-b1f9-cb289a964834.jfif',7,'<p>南昌米粉真的好吃，希望下次还来吃！</p><p><br></p>','1738888888','2020-03-25 18:46:13'),(13,'南昌美食','藜蒿炒腊肉','南昌','8866f9db-3825-4c3c-ba52-d804480fb41b.jpg',20,'<p>&nbsp;&nbsp;&nbsp;&nbsp;藜蒿炒腊肉是一道江西特色名菜，为十大赣菜之一。</p><p><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 16px;\">制作步骤为：将藜蒿去根后的嫩茎切成段，腊肉切成丝。先炒腊肉，后加入藜蒿和葱段煸炒，加入汤料，片刻起锅即成。</span><span style=\"font-size: 16px;\">成菜后，腊肉金</span><span style=\"font-size: 16px;\">黄，藜蒿青绿，脆嫩爽口，且有一股特别的清香味道。</span></p><p>&nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">在所有</span>蔬菜<span style=\"font-size: 16px;\">与腊肉的组合中，数</span>藜蒿<span style=\"font-size: 16px;\">达到了最高境界。咸香柔软的腊肉，愈发衬出藜蒿特立独行的香气。</span><span style=\"font-size: 16px;\">藜蒿如青丝带，嫩绿中发亮，腊肉金红微白，黄绿相间，观之令人食欲顿增。</span></p><p><img src=\"/static/upload/foodFile/62f3d270-961a-4c1a-af64-a855a1e16224.jpg\" style=\"max-width:100%;\"></p>','17333333333','2020-04-20 23:49:15'),(14,'吉安美食之安福火腿','安福火腿','吉安','378f32e5-49ed-47da-a324-75c0d45fa172.jfif',25,'<p><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><b>安福火腿</b><span style=\"font-size: 16px;\">是</span>江西省吉安市安福县<span style=\"font-size: 16px;\">的特色传统名肴，</span><span style=\"font-size: 16px;\">为中国三大火腿之一，是中国江西省著名特产之一，不仅畅销内地及港、澳、台地区，而且远销东南亚各国。1915年选送</span>巴拿马<span style=\"font-size: 16px;\">国际博览会展出获金牌奖。由安福火腿集团公司选送参加1996年“国际食品及技术博览会”的火腿片、火腿心、熟制火腿全部荣膺金牌。制作火腿的原料是</span>安福米猪<span style=\"font-size: 16px;\">的后腿。天下的肥猪千千万，为啥安福米猪后腿制的火腿特别走俏呢？这除了当地老表在生产加工中反复总结经验，有独特的制作方法外，有趣的民间故事也增加了火腿的知名度，使火腿远销四方。</span></p><p>&nbsp; &nbsp; <b>营养价值</b><span style=\"font-size: 16px;\">较高，</span><span style=\"font-size: 16px;\">其形如柳叶，脚蹄短小，腿身饱满，皮薄肉嫩，精多肥少，色红味香，经久不变质。只要保管得当，存放二、三年仍色味如初，精肉鲜红似火，肥肉洁白晶莹，是烹制 佳肴的上乘原料。而且含有的蛋白质、脂肪、钙、铁及多种氨基酸等营养成分，既 是补益身体的营养食品，也是赠送亲友的上等礼物。</span></p><p><img src=\"/static/upload/foodFile/aae9918f-eefe-4483-b556-1f33a7db2da5.jpg\" style=\"max-width:100%;\"></p>','18855555555','2020-04-20 23:56:56'),(16,'色香味美的莲花血鸭','莲花血鸭','江西萍乡','e47bbd95-1dac-4405-b3e3-dd2cbe846e3e.jfif',22,'<div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;<b>莲花血鸭</b>属赣菜系萍乡菜一支，是江西省萍乡市莲花县的一道特色名菜。莲花血鸭因具有“色美味香、鲜嫩可口”的特点而被列入“十大赣菜”之一。</div><div label-module=\"para\">2009年申报省级非物质文化遗产成功。2018年9月，被评为“中国菜”之江西十大经典名菜。</div><p>&nbsp; &nbsp;<b>&nbsp;适用人群</b>：素体虚寒、受凉引起的不思饮食、胃部冷痛、腹泻清稀、腰痛及寒性痛经以及肥胖、动脉硬化、慢性肠炎应少食、感冒患者均不宜食用。</p><p>&nbsp; &nbsp;<b>&nbsp;营养价值</b>：鸭肉所含B族维生素和维生素E较其他肉类多，能有效抵抗脚气病，神经炎和多种炎症，还能抗衰老。鸭肉中含有较为丰富的烟酸，它是构成人体内两种重要辅酶的成分之一，对心肌梗死等心脏疾病患者有保护作用。</p><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;鸭肉中的脂肪含量适中，约为7.5%比鸡高，比猪肉低，并较均匀地分布于全身组织中。脂肪酸主要是不饱和脂肪酸和低碳饱和脂肪酸，因此，熔点低，约为35℃，易于消化。鸭肉还含有约0.8%-1.5%的无机物。与畜肉不同的是，鸡肉中钾含量最高，100克可食部分达到近300毫克。此外，还含有较高的铁、铜、锌等衡量元素。</div><p><img src=\"/static/upload/foodFile/b85f30e7-6888-4531-bb3e-924bdb4160c0.jpg\" style=\"max-width:100%;\"></p><p><br></p>','13588888888','2020-04-21 00:35:11');

/*Table structure for table `tp_forum` */

DROP TABLE IF EXISTS `tp_forum`;

CREATE TABLE `tp_forum` (
  `tp_fid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_author_id` varchar(100) DEFAULT NULL,
  `tp_author` varchar(100) DEFAULT NULL,
  `tp_title` varchar(100) DEFAULT NULL,
  `tp_sub_title` varchar(100) DEFAULT NULL,
  `tp_creat_time` datetime NOT NULL,
  `tp_tag` varchar(100) DEFAULT NULL,
  `tp_tcontent` text,
  PRIMARY KEY (`tp_fid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tp_forum` */

insert  into `tp_forum`(`tp_fid`,`tp_author_id`,`tp_author`,`tp_title`,`tp_sub_title`,`tp_creat_time`,`tp_tag`,`tp_tcontent`) values (4,'4','admin','井冈山革命烈士陵园','井冈山革命烈士陵园','2020-03-26 11:37:14','红色文化','<div label-module=\"para-title\"><h3>一尊佛</h3></div><div label-module=\"para\">北山坐北朝南、山形如佛，矗立在井冈山市的茨坪的当中。站在北山纪念碑的最高处往山下看，碑林和雕塑圆仿如佛的左右手；纪念堂正处在心脏的位置，头部就是纪念碑的位置了。沿着山道向左至右地走一遍，也就对佛进行了一次拜谒。在纪念堂向英魂鞠躬，在纪念碑向神灵致意。</div><div label-module=\"para-title\"><h3>人一生</h3></div><div label-module=\"para\">北山的建筑与山体通贯，从进入陵园到踏上台阶由左而右地走一回，其实是通过时空转移的方式让你已经经历了一次人生。从我们迈向的第一步，意味着踏上了你人生的旅途。而选择一种怎样的信仰，纪念堂是标志。沿着蜿蜒曲折一直向上的路攀升，意味着你人生的跋涉。走到纪念碑你的人生已经到达了颠峰。接下来的人生轻松而自然，你来到雕塑圆，你是否在你的人生道路上有所建树，丰碑永存呢？人生所有蓄积的能量在奋斗的过程中已经耗尽，你的残生犹如下山的台阶奔流直下。再回到你开始登跃台阶的地方，往你的身后回望一看：哪儿来只有再往哪儿去！十八年后再上井冈山吧！</div><div label-module=\"para-title\"><h3>一条路</h3></div><div label-module=\"para\">井冈山是一条中国革命的路。一九二七年的毛泽东，上井冈山走出了一条井冈山的山路，这条路后来成为了中国革命的胜利道路。在毛泽东时代有这么一句话：“井冈小路通天下、毛泽东思想照全球”。这其中蕴涵的深刻含义在经历过<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%AF%9B%E6%B3%BD%E4%B8%9C%E6%97%B6%E4%BB%A3/8937667\">毛泽东时代</a>的中国人都懂，或者你到井冈山来也能明白。上不上北山是你的自由，但是要走党的路的人就一定要上北山。因为北山是每一个共产党员向党宣誓的地方。</div>'),(6,'4','admin','hello','hello','2020-04-22 10:00:08','hello','<p>hello</p>'),(7,'4','admin','测试','测试','2020-06-05 12:41:33','测试','<p><br></p>');

/*Table structure for table `tp_hotel` */

DROP TABLE IF EXISTS `tp_hotel`;

CREATE TABLE `tp_hotel` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `local` varchar(100) DEFAULT NULL,
  `house_type` varchar(100) DEFAULT NULL,
  `bed_type` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `people_num` varchar(100) DEFAULT NULL,
  `zip` varchar(100) DEFAULT NULL,
  `house_size` varchar(100) DEFAULT NULL,
  `price` int(30) DEFAULT NULL,
  `img_url` varchar(100) DEFAULT NULL,
  `content` text,
  `created` datetime NOT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `tp_hotel` */

insert  into `tp_hotel`(`hid`,`title`,`local`,`house_type`,`bed_type`,`phone`,`people_num`,`zip`,`house_size`,`price`,`img_url`,`content`,`created`) values (7,'如家酒店','南昌','套间，豪华间','双人床','13755555555','2','江西省南昌市xxx区xxx街道','60',188,'54ca7db0-0fed-499f-9429-a137b24bc7ad.jpg','<p>舒适豪华</p><p><img src=\"/static/upload/hotelFile/2c1d4624-61a6-484b-afed-dfa0bf99c1a8.jpg\" style=\"max-width:100%;\"><br></p>','2020-03-18 10:53:19'),(8,'七天快捷酒店','萍乡','套间，豪华间','单人床','13755555555','1','江西省萍乡市xxx街道','30',98,'6642b0ca-388f-47bc-be40-070adc6a6c4f.jpg','<p>舒适简单</p><p><img src=\"/static/upload/hotelFile/00733f14-958d-47c9-89d5-717c7b63e492.jpg\" style=\"max-width:100%;\"><br></p><p><br></p>','2020-03-20 19:38:16'),(9,'汉庭大酒店','南昌','多套间，豪华间','双人床','15888888888','2','江西省南昌市xxx区xxx街道','60',188,'b5ec1f2a-d3ae-48f1-b644-2072e4588a20.jpg','<p>汉庭大酒店，舒适豪华，交通便利。</p><p><img src=\"/static/upload/hotelFile/6021108c-c121-4c8b-8ac2-4cf2c3a6ab3e.jpg\" style=\"max-width:100%;\"><br></p><p><br></p>','2020-03-20 19:41:49'),(10,'瑞金国际大酒店','瑞金','豪华单间','单人床','15866655548','1','江西省赣州市红都大道282','50',153,'0b57848b-3940-463c-becb-d11f19c6e17a.png','<p>&nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">瑞金国际大酒店坐落于瑞金市最繁华地段红都大道，配有功能完善的现代化设施和一流管理的商务旅游饭店；酒店距离汽车站约1公里，体育馆约1公里，市政府不足1公里，中华苏维埃共和国旧址不足三公里，交通便利，环境优雅。</span><br></p><br><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<img src=\"/static/upload/hotelFile/586a2a40-b2d0-4aae-a7b3-a16f84ea0139.jpg\" style=\"max-width:100%;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p><br></p></div><p><br></p>','2020-04-21 20:39:11'),(11,'维也纳酒店（吉安人民广场店）','吉安','豪华套间','双人床','15689974545','2','吉安市井冈山大道新世界广场A座','50',300,'585db74e-e681-4f5b-bf0a-7cb8ad428cd4.jpg','<p>&nbsp;&nbsp;&nbsp;&nbsp;维也纳酒店（吉安人民广场店）位于井冈山大道新世界广场A座，毗邻天虹商场、文山步行街、井冈山附属医院、吉安客运汽车站、吉安火车站、白鹭洲公园；距离钓源古村约30分钟车程；距离城南、城北高速入口约15分钟车程，交通便利，有多路公交可直达酒店。<br>　<img src=\"/static/upload/hotelFile/b88a9f9d-30c0-406e-9ba9-2327da17e69e.jpg\" style=\"font-size: 16px; max-width: 100%;\"><span style=\"font-size: 16px;\">这里是一家商务酒店，由名师设计，装修风格融入了欧陆情调，温馨、舒适、典雅。酒店共拥有各类豪华客80余间，提供50多个停车位。</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;酒店秉承维也纳“绅士般的体验，淑女般的亲切”的核心产品价值理念，提供超值、艺术、环保、健康、安全、助眠、便捷360度的全方位体验。&nbsp;&nbsp;<br></p><p><br></p>','2020-04-21 20:47:13'),(12,'萍乡天鹅时尚酒店','萍乡','豪华单间','单人床','15866655548','1','江西省萍乡市昭萍东路','35',168,'10b3b90f-8681-4fe0-8fe1-ab887840ad10.png','<p>&nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">酒店干净卫生、安全舒适，房内设有24小时热水、洗漱用品等，让你感受到家的惬意与温馨，是你出行理想的下榻之所。</span><br></p><p><img src=\"/static/upload/hotelFile/3a080170-f085-4744-9bb5-ba7f8e14848f.jpg\" style=\"max-width:100%;\"><span style=\"font-size: 16px;\"><br></span></p><p><br></p>','2020-04-21 20:52:23'),(21,'萍乡天鹅时尚酒店','萍乡','豪华套间','双人床','13767526805',NULL,'江西省萍乡市昭萍东路','50',198,'3b11e556-3dda-4b90-bc2c-7614784373ef.jpg','<p>&nbsp; &nbsp; 酒店干净卫生、安全舒适，房内设有24小时热水、洗漱用品等，让你感受到家的惬意与温馨，是你出行理想的下榻之所。<br></p><p><br></p><p><img src=\"http://localhost:8080/static/upload/hotelFile/3a080170-f085-4744-9bb5-ba7f8e14848f.jpg\"></p>','2020-06-05 12:00:26');

/*Table structure for table `tp_user` */

DROP TABLE IF EXISTS `tp_user`;

CREATE TABLE `tp_user` (
  `tp_uid` int(11) NOT NULL AUTO_INCREMENT,
  `tp_uname` varchar(100) DEFAULT NULL,
  `tp_uemail` varchar(100) DEFAULT NULL,
  `tp_upwd` varchar(100) DEFAULT NULL,
  `tp_age` varchar(100) DEFAULT NULL,
  `tp_gender` varchar(100) DEFAULT NULL,
  `tp_upic` varchar(100) DEFAULT NULL,
  `tp_phone` varchar(100) DEFAULT NULL,
  `tp_regdate` timestamp NULL DEFAULT NULL,
  `tp_update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`tp_uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tp_user` */

insert  into `tp_user`(`tp_uid`,`tp_uname`,`tp_uemail`,`tp_upwd`,`tp_age`,`tp_gender`,`tp_upic`,`tp_phone`,`tp_regdate`,`tp_update_time`) values (4,'admin','admin@qq.com','admin','21','男','3ffa3727-3fee-4084-823c-5c51490b95d6.png','13767526803','2020-03-17 13:08:46','2020-03-17 13:08:46'),(5,'root','root@qq.com','root',NULL,NULL,'c89181c8-0add-4d33-b3e1-16902215d76d.png',NULL,'2020-03-26 17:47:42','2020-03-26 17:47:42');

/*Table structure for table `tp_viewpoint` */

DROP TABLE IF EXISTS `tp_viewpoint`;

CREATE TABLE `tp_viewpoint` (
  `tp_vid` int(30) NOT NULL AUTO_INCREMENT,
  `tp_title` varchar(100) DEFAULT NULL,
  `tp_vname` varchar(100) DEFAULT NULL,
  `tp_vtype` varchar(100) DEFAULT NULL,
  `tp_vpic` varchar(100) DEFAULT NULL,
  `tp_vphone` varchar(100) DEFAULT NULL,
  `tp_level` varchar(100) DEFAULT NULL,
  `tp_price` int(30) DEFAULT NULL,
  `tp_location` varchar(100) DEFAULT NULL,
  `tp_zip` varchar(100) DEFAULT NULL,
  `tp_opentime` varchar(100) DEFAULT NULL,
  `tp_creatTime` timestamp NULL DEFAULT NULL,
  `tp_vcontent` text,
  PRIMARY KEY (`tp_vid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `tp_viewpoint` */

insert  into `tp_viewpoint`(`tp_vid`,`tp_title`,`tp_vname`,`tp_vtype`,`tp_vpic`,`tp_vphone`,`tp_level`,`tp_price`,`tp_location`,`tp_zip`,`tp_opentime`,`tp_creatTime`,`tp_vcontent`) values (13,'南昌八一起义纪念馆','八一起义纪念馆','红色景点','5e57a618-eb92-49b3-9841-3a6342b03b44.jpg','17388888888','一级博物馆',100,'江西南昌','江西省南昌市中山路中段380号','2020.05.30','2020-03-17 14:10:58','<div label-module=\"para\"><b>南昌八一纪念馆&nbsp; &nbsp;</b></div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;南昌八一起义纪念馆是为纪念南昌起义而设立的专题纪念馆，成立于1956年，1959年10月1日正式对外开放。南昌八一起义纪念馆位于江西省南昌市西湖区中山路，占地面积5903平方米。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;南昌八一起义纪念馆基本陈列陈展各类图片、图表509幅，文物展品407件（套），艺术品51件；陈展内容主要有：新馆大楼南昌起义、人民军队光辉历程以及旧址复原陈列等。</div><div label-module=\"para\"><b>综述：</b>&nbsp;&nbsp;</div><div label-module=\"para\"><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 16px;\">南昌八一起义纪念馆基本陈列陈展面积达4492平方米，展线998米；展览空间分为两层，一层为主要展览区域，二层主要为专题展区和多媒体互动展区；展览共分“危难中奋起”“伟大的决策”“打响第一枪”“南征下广东”“转战上井冈”“群英耀中华”6个部分、21个展示单元；展览以“伟大的开端”为主题，以“强军之路”为主线，展示了自八一南昌起义开始，我们的中国人民解放军从小到大，由弱到强的光辉历程，增加了“中国共产党早期军事探索”“江西省委及民众对起义的支援”等内容展示</span><span style=\"font-size: 16px;\">。</span></div><div label-module=\"para\"><span style=\"font-size: 16px;\"><br></span></div><div label-module=\"para\"><span style=\"font-size: 16px;\"><br></span></div><div label-module=\"para\"><span style=\"font-size: 16px;\">&nbsp;&nbsp;</span><img src=\"/static/upload/contentFile/4ac6e702-124e-4f15-ab56-986fdbb70d32.jpeg\" style=\"font-size: 16px; max-width: 100%;\"></div><p><br></p>'),(14,'井冈山革命博物馆','井冈山革命博物馆','红色文化','094486f4-d6ec-45fa-912f-4cbca0b90051.jpg','1888888888','一级博物馆',50,'江西吉安','江西省井冈山市茨坪红军南路','2020.05.29','2020-03-18 09:12:45','<h1><b>井冈山革命博物馆</b><br></h1><div>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">该博物馆占地面积1.782公顷，总建筑面积20030平方米，其中展厅面积8436平方米；馆藏文物3万余件，珍贵文献资料和历史图片2万余份，珍藏党和国家领导人、著名书画家及社会各界知名人士的墨宝珍迹千余幅。保存毛泽东、朱德等党和国家领导人重上井冈山时的影视资料数百件。</span><b><br></b></div><div>&nbsp; &nbsp; &nbsp; &nbsp; <span style=\"font-size: 16px;\">井冈山革命博物馆坐落在井冈山市茨坪红军南路，占地面积1.782公顷，主体建筑为四层框架结构，一层为停车场、报告厅，二层为文物库房及办公用房，三、四层为展厅，总建筑面积20030平方米，其中展厅面积8436平方，用于宣传展示功能面积达10181平方米，超过总面积的51%。</span><span style=\"font-size: 16px;\"><br></span></div><div>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span style=\"font-size: 16px;\">朱德题写“井冈山革命博物馆”馆名手稿，质地为白色宣纸，长方形，竖幅，高70厘米，宽29厘米，装裱在宣纸上。楷书，竖行，墨字，字迹清晰。内容为“井冈山革命博物馆”馆名。</span><br></div><div label-module=\"para\">1928年初，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E6%9C%B1%E5%BE%B7\">朱德</a>发动和领导了湘南暴动，4月他率部上井冈山与毛泽东领导的部队会师，成立了中国工农红军第四军，他任军长。这件题字，是朱德委员长1962年3月4日至6日重上井冈山时，于3月5日，在井冈山宾馆应时任中共井冈山管理局党委书记、局党委宣传部部长兼井冈山革命博物馆筹备处主任林史的要求而题写的。此件题字后由井冈山管理局常委办公室移交给井冈山革命博物馆收藏。1994年5月，国家文物局文物鉴定专家组阮家新、万冈等5人确认为国家一级馆藏品。</div><p><br></p><p><img src=\"/static/upload/contentFile/08e950f2-f5f3-4231-b99d-143734aee01f.jpg\" style=\"max-width:100%;\"><br></p><p><br></p>'),(15,'南昌八一起义纪念塔','八一起义纪念塔','红色景点','a3aa54b4-33c3-4c9f-b7a6-d7c55706f843.jpg','17388888888','二级',0,'江西南昌','江西省南昌市西湖区丁公路街道八一大道社区八 一广场南端','2020.05.29','2020-03-18 15:41:04','<p><b>南昌八一起义纪念塔</b></p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">南昌八一起义纪念塔为八一广场</span><span style=\"font-size: 16px;\">标志性建筑，塔为长方体，高53.6米，由塔基、塔座、塔身、塔顶四部分组成。塔座正面镌刻“八一南昌起义简介”碑文，东、南、西三面各有一幅反映武装起义的人物浮雕。塔身正面为“八一南昌起义纪念塔”铜胎鎏金大字。塔顶由一支直立的巨型“汉阳造”步枪和一面八一军旗组成。</span><b><br></b></p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">八一南昌起义纪念塔正北面是叶剑英元帅题写的“八一南昌起义纪念塔”九个铜胎鎏金大字，下嵌“八一南昌起义简介”花岗石碑。其他三面是“宣布起义”、“攻打敌营”、“欢呼胜利”三幅大型花岗石浮雕。塔身两侧各有一片翼墙，嵌有青松和万年青环抱的中国工农红军旗徽浮雕。塔顶由直立的花岗石雕“汉阳造”步枪和用红色花岗石拼贴的八一军旗组成。</span><span style=\"font-size: 16px;\"><br></span></p><p><span style=\"font-size: 16px;\"><br></span></p><p><img src=\"/static/upload/contentFile/527037b9-096e-4075-9c06-604740cc0a80.jpg\" style=\"max-width:100%;\"><span style=\"font-size: 16px;\"><br></span></p><p><br></p>'),(16,'井冈山茨坪革命旧址群','井冈山茨坪革命旧址群','红色景点','fea432b3-4b38-42e0-90ac-5adc5b4aaa67.jpg','18366666666','二级',40,'江西吉安','江西省井冈山市茨坪镇东山脚下店上村','2020.05.31','2020-03-18 15:57:10','<div><h3><b>茨坪革命旧址群</b></h3><h3>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: inherit; font-size: 16px;\">茨坪革命旧址群</span>位于风景如画的挹翠湖岸边，是一组土木结构的民房，其中包括：毛泽东同志旧居、红四军军部旧址、红四军军官教导队旧址、红四军军械处旧址、新遂边陲特别区工农兵政府公卖处旧址、防务委员会旧址等。</h3></div><p><br></p><p><img src=\"/static/upload/contentFile/9e3f7946-577c-409a-b806-ad3faa6504a9.jpg\" style=\"max-width:100%;\"><br></p><p><br></p><p><img src=\"/static/upload/contentFile/cfc9d4f4-edcb-482f-9b24-3a352406c50b.jpeg\" style=\"max-width:100%;\"><br></p><p><br></p>'),(17,'萍乡秋收起义广场','萍乡秋收起义广场','红色旅游','2d3e5cff-ddd1-4766-b48f-ebad82db86cb.jpeg','1888888888','国家AAA级旅游景区',0,'江西萍乡','江西省萍乡市城北','暂无','2020-04-21 00:05:11','<p><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><strong>秋收起义广场</strong>位于江西省萍乡市城北，总面积346亩，绿化覆盖率达60%。广场以萍水河为纽带，由中心广场、西北广场、东南广场、东北广场组合而成。&nbsp;&nbsp;<br></p><div>&nbsp;&nbsp;&nbsp;&nbsp;建设旨在纪念秋收起义这一历史事件，广场建筑按轴线设计分布，南北轴线上建设有户外电子屏、升旗台、音乐喷泉、纪念碑及纪念碑基座内的秋收起义陈列馆;东西轴线上亭廊、花架、石雕与艺术膜结构完美融合，使广场集纪念展览、庆典集会、休闲娱乐等多种功能于一体，成为萍乡如诗如画的\"城市会客厅\"。</div><p>&nbsp;&nbsp;&nbsp;&nbsp;秋收起义广场为\"全国爱国主义教育示范基地\"、\"全国红色旅游经典景区\"、\"国家AAA级旅游景区\"。&nbsp;</p><p><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 16px;\">1998年9月，经萍乡市委常委会讨论通过， “秋收起义广场纪念碑”建在原萍乡“昭萍广场”，同时将 “昭萍广场”更名为 `秋收起义广场\"。</span></p><p><span style=\"font-size: 16px;\">&nbsp; &nbsp;&nbsp;</span><span style=\"font-size: 16px;\">1999年9月9日，中共中央总书记、国家主席、中央军委主席江泽民为秋收起义纪念碑题写了“秋收起义纪念碑”碑名，纪念碑于，2000年8月27日正式落成。</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;秋收起义纪念碑建在秋收起义广场中央，碑高30.9米，占地面积151平方米，纪念碑正面镌刻着江译民题写的碑名：\"秋收起义纪念碑\"，碑背面是毛泽东的词《西江月·秋收起义》。基座正面是碑文，其他三面为浮雕，按顺时针方向依次为 《张家湾的红灯》、 《霹震&nbsp;<span style=\"font-size: 16px;\">一声暴动》、《转战上井冈》，生动展现</span><a title=\"秋收起义广场\" href=\"https://baike.baidu.com/pic/%E7%A7%8B%E6%94%B6%E8%B5%B7%E4%B9%89%E5%B9%BF%E5%9C%BA/1336854/21518701/908fa0ec08fa513d39485020346d55fbb3fbd969?fr=lemma&amp;ct=cover\" target=\"_blank\" nslog-type=\"10000206\" style=\"font-size: 16px;\"><span style=\"font-size: 16px; color: rgb(51, 51, 51);\">了秋收起义的历史画面。碑身有线刻的猎猎战旗和崇山峻岭，表示秋收起义是中国共产党领导和工农兵联合的武装斗争，第一次举起工农革命军旗帜，并转战井冈山创建革命根据地。纪念碑由“9”字、浮雕、题词、长城、安源路矿工人俱乐部徽标、碑柱、火焰（火炬）、五角星、碑文、红旗、山川、稻穗等图案协调配置、有机组合。长城堡连碑柱27米，基座27级台阶、高3.9米，碑柱顶部正面与背面造型为两个“9”字，连缀起来表明秋收起义的时间为1927年9月9日，同时又有“九重天”的寓意。</span></a></p><p><img src=\"/static/upload/contentFile/8ead8551-aa40-424d-82e9-5f7b3ec5b0bc.jpg\" style=\"font-size: 16px; max-width: 100%;\"><span style=\"font-size: 16px; color: rgb(51, 51, 51);\"><a title=\"秋收起义广场\" href=\"https://baike.baidu.com/pic/%E7%A7%8B%E6%94%B6%E8%B5%B7%E4%B9%89%E5%B9%BF%E5%9C%BA/1336854/21518701/908fa0ec08fa513d39485020346d55fbb3fbd969?fr=lemma&amp;ct=cover\" target=\"_blank\" nslog-type=\"10000206\" style=\"font-size: 16px;\">&nbsp;</a></span></p>'),(19,'中华苏维埃临时中央政府旧址群','苏维埃旧址群','红色景点','1cc36cf1-4ba3-4ef0-bfbe-20488b7494d9.jpg','1888888888','暂无',0,'江西瑞金','江西省瑞金市','暂无','2020-04-21 09:49:25','<p>&nbsp; &nbsp;&nbsp;<b>瑞金</b>是享誉中外的红色故都，共和国摇篮。从1931年9月至1934年10月，瑞金一直是中央苏区和中华苏维埃共和国政治、军事活动中心，中央党、政、军、群机构均驻在瑞金，毛泽东、刘少奇、周恩来、朱德、陈云、邓小平等老一辈无产阶级革命家也都在瑞金从事过伟大的革命实践，因此遗留了众多的革命旧居、旧址和纪念建筑物，其中全国重点文物保护单位有15处、省级文物保护单位4处、市级文物保护单位有20处。由于当年中央机关在瑞金几次迁移，瑞金形成了叶坪、沙洲坝和云石山3个旧址群。&nbsp;&nbsp;<br></p><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;旧址原是谢氏宗祠，已有几百年的历史，是中华苏维埃共和国临时中央政府的诞生地和1931年11月至1933年4月的驻地。&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;1931年11月7日，中华苏维埃第一次全国代表大会在这里隆重召开。来自赣南、闽西、赣东北、湘赣、湘鄂西、琼崖等根据地的代表，以及在国民党统治区的全国总工会、全国海员总工会的610名代表出席了大会.大会历时14天，听取了毛泽东作的政治问题报告、项英作的劳动法草案报告、张鼎丞作的土地问题报告、朱德作的红军问题报告、周以栗作的经济政策问题报告、王稼祥作的少数民族问题报告、邓广仁作的工农检察问题报告、任弼时作的苏维埃宪法问题报告。讨论通过了苏维埃宪法大纲、土地法、劳动法及红军问题、经济政策、工农检察问题、少数民族问题等决议案。选举了毛泽东、项英、张国焘、周恩来、朱德等63人为中央执行委员会委员，组成中央执行委员会，作为大会闭幕后的最高政权机关。</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;大会最后发表了《中华苏维埃共和国临时中央政府对外宣言》，向全国全世界庄严宣告中华苏维埃共和国临时中央政府正式成立，定都瑞金。&nbsp;</div><div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;会议结束后，谢氏宗祠被木板隔成15个房间，作为各个部的办公室。&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;1933年4月，临时中央政府从这里迁驻沙洲坝后，依然在谢氏宗祠内召开过许多重要会议，如8县区以上负责人查田运动大会，8县贫农团代表大会，中央苏区南部17县经济建设大会，中央苏区南部18县选举运动大会。&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;解放后，按“一苏”大会的场景和临时中央政府原貌进行复原陈列并对外开放。&nbsp;</div><p>&nbsp;&nbsp;&nbsp;&nbsp;中华苏维埃第二次代表大会旧址</p><p><img src=\"http://localhost:8080/static/upload/contentFile/31dbb1c5-c01f-439e-abaf-6e8e6351cf47.jpg\"></p><p><br></p>'),(20,'长征第一山——云石山','云石山','自然风景','da8e12de-a335-44b4-a4db-605d298183de.jfif','18356565656','国家AAA级旅游景区',0,'江西瑞金','江西省瑞金市境内西部','暂无','2020-04-21 20:16:42',''),(21,'中央革命根据地历史博物馆','中央革命根据地博物馆','博物馆','c3025661-b609-4f35-b8a2-a47d9b2965d4.jpg','18356575859','国家AAAA级旅游景区',0,'江西瑞金','江西省瑞金市苏维埃纪念园内','工作日','2020-04-21 20:28:39','<p><br></p>'),(24,'中央革命根据地历史博物馆','中央革命根据地博物馆','博物馆','c3025661-b609-4f35-b8a2-a47d9b2965d4.jpg','18356575859','国家AAAA级旅游景区',20,'江西瑞金','江西省瑞金市苏维埃纪念园内','暂无','2020-05-20 17:10:12',NULL),(25,'南昌八一起义纪念塔','八一起义纪念塔','红色景点','a3aa54b4-33c3-4c9f-b7a6-d7c55706f843.jpg','17388888888','二级',30,'江西南昌','江西省南昌市西湖区丁公路街道八一大道社区八 一广场南端','2020.05.29','2020-05-20 17:13:02','<p><b>南昌八一起义纪念塔</b></p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">南昌八一起义纪念塔为八一广场</span><span style=\"font-size: 16px;\">标志性建筑，塔为长方体，高53.6米，由塔基、塔座、塔身、塔顶四部分组成。塔座正面镌刻“八一南昌起义简介”碑文，东、南、西三面各有一幅反映武装起义的人物浮雕。塔身正面为“八一南昌起义纪念塔”铜胎鎏金大字。塔顶由一支直立的巨型“汉阳造”步枪和一面八一军旗组成。</span><b><br></b></p><p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size: 16px;\">八一南昌起义纪念塔正北面是叶剑英元帅题写的“八一南昌起义纪念塔”九个铜胎鎏金大字，下嵌“八一南昌起义简介”花岗石碑。其他三面是“宣布起义”、“攻打敌营”、“欢呼胜利”三幅大型花岗石浮雕。塔身两侧各有一片翼墙，嵌有青松和万年青环抱的中国工农红军旗徽浮雕。塔顶由直立的花岗石雕“汉阳造”步枪和用红色花岗石拼贴的八一军旗组成。</span><span style=\"font-size: 16px;\"><br></span></p><p><span style=\"font-size: 16px;\"><br></span></p><p><img src=\"/static/upload/contentFile/527037b9-096e-4075-9c06-604740cc0a80.jpg\" style=\"max-width:100%;\"><span style=\"font-size: 16px;\"><br></span></p><p><br></p>'),(27,'测试1','测试1','测试1','c3a75bad-87d1-4a09-b178-27558dbc19dc.jpg','18888888888','二级',100,'测试1','测试1','2020.06.06','2020-06-06 09:37:16','');

/*Table structure for table `words` */

DROP TABLE IF EXISTS `words`;

CREATE TABLE `words` (
  `lw_id` int(11) NOT NULL AUTO_INCREMENT,
  `lw_name` varchar(100) DEFAULT NULL,
  `lw_date` varchar(100) DEFAULT NULL,
  `lw_content` varchar(100) DEFAULT NULL,
  `lw_for_name` varchar(100) DEFAULT NULL,
  `lw_for_article_id` varchar(100) DEFAULT NULL,
  `lw_forumId` varchar(100) DEFAULT NULL,
  `lw_hotel_id` varchar(100) DEFAULT NULL,
  `lw_food_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`lw_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `words` */

insert  into `words`(`lw_id`,`lw_name`,`lw_date`,`lw_content`,`lw_for_name`,`lw_for_article_id`,`lw_forumId`,`lw_hotel_id`,`lw_food_id`) values (33,'admin','2020-06-06 09:37:33','测试1',NULL,'27',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
