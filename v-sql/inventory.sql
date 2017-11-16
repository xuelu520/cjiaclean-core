drop table if exists measureUnitGroup;
/*==============================================================*/
/* Table: measureUnitGroup                                      */
/*==============================================================*/
create table measureUnitGroup
(
   unitGroupId          bigint not null auto_increment comment '主键Id',
   unitGroupName        varchar(20) comment '计量单位组名',
   unitGroupCode        varchar(20) comment '计量单位代码',
   basicUnit            varchar(10) comment '基本计量单位',
   primary key (unitGroupId)
);


drop table if exists measureUnit;
/*==============================================================*/
/* Table: measureUnit                                           */
/*==============================================================*/
create table measureUnit
(
   unitId               bigint not null auto_increment comment '主键Id',
   unitGroupId          bigint comment '计量单位组id',
   unit                 varchar(10) comment '计量单位',
   basicUnitRate        varchar(10) comment '与基本计量单位换算率',
   primary key (unitId)
);


drop table if exists warehouse;
/*==============================================================*/
/* Table: warehouse                                             */
/*==============================================================*/
create table warehouse
(
   warehouseId          bigint not null auto_increment comment '库房id',
   warehouseName        varchar(255) comment '库房名称',
   warehouseType        varchar(2) comment '仓库类型',
   orgType              varchar(2) comment '0. 无关联 1. 关联酒店 2. 关联公司',
   orgValue             varchar(50) comment '关联值',
   primary key (warehouseId)
);


drop table if exists inventory;
/*==============================================================*/
/* Table: inventory                                             */
/*==============================================================*/
create table inventory
(
   inventoryId          bigint not null auto_increment comment '商品库存id',
   goodsId              bigint comment '商品id',
   productId            bigint comment '货品id',
   materielId           bigint comment '物料id',
   warehouseId          bigint comment '仓库id',
   unitId               bigint comment '计量单位id',
   unit                 varchar(10) comment '基本计量单位',
   inventoryNum         int comment '库存',
   freeInventoryNum     int comment '可用库存',
   warnInventoryNum     int default 0 comment '安全库存',
   channelId            bigint comment '渠道的ID',
   rateId               bigint comment '价格ID',
   primary key (inventoryId)
);



drop table if exists inventoryRecord;
/*==============================================================*/
/* Table: inventoryRecord                                       */
/*==============================================================*/
create table inventoryRecord
(
   recordId             bigint not null auto_increment comment '记录id',
   voucherNo            varchar(50) comment '凭证号',
   lineNum              bigint comment '行号',
   goodsId              bigint comment '商品id',
   productId            bigint comment '货品id',
   materielId           bigint comment '物料id',
   warehouseId          bigint comment '仓库id',
   operateType          varchar(2) default '0' comment '操作类型：1. 下单减可用库存',
   flowType             varchar(2) comment '流向类型：0.进 1出',
   measureUnit          varchar(10) comment '计量单位',
   measureNum           int comment '计量数量',
   basicUnit            varchar(10) comment '基本计量单位',
   basicNum             int comment '基本计量数量',
   remark               text comment '备注',
   createTime           datetime comment '创建时间',
   createUser           varchar(50) comment '创建人',
   updateTime           datetime comment '更新时间',
   updateUser           varchar(50) comment '更新人',
   primary key (recordId)
);



drop table if exists materiel;
/*==============================================================*/
/* Table: materiel                                              */
/*==============================================================*/
create table materiel
(
   materielId           bigint not null auto_increment comment '主键id',
   materielName         varchar(100) comment '名称',
   materielSn           varchar(20) comment '系统编码',
   brief                varchar(255) comment '简介',
   description          text comment '详细描述',
   unitGroupId          varchar(20) comment '计量单位组id',
   unitId               bigint comment '默认计量单位Id',
   unit                 bigint comment '默认计量单位',
   status               varchar(2) comment '0.否 1.是',
   createTime           datetime comment '创建时间',
   createUser           varchar(20) comment '创建人',
   updateTime           datetime comment '更新时间',
   updateUser           varchar(20) comment '更新人',
   primary key (materielId)
);




drop table if exists goodsMateriel;
/*==============================================================*/
/* Table: goodsMateriel                                         */
/*==============================================================*/
create table goodsMateriel
(
   goodsMaterieId       bigint not null auto_increment comment '主键Id',
   goodsId              bigint comment '商品id',
   materielId           bigint comment '物料id',
   goodsNum             int comment '商品数量',
   materielNum          int comment '物料数量',
   unitId               bigint comment '计量单位id',
   unit                 varchar(10) comment '基本计量单位',
   hotelId              bigint comment '酒店id',
   primary key (goodsMaterieId)
);