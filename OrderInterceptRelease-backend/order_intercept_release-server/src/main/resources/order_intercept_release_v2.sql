CREATE TABLE `rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL COMMENT '规则名称',
  `json` text NOT NULL COMMENT '规则配置json串',
  `sql` text NOT NULL COMMENT 'sql',
  `params` text NOT NULL COMMENT 'sql参数',
  `effect_tine_start` datetime NOT NULL COMMENT '拦截生效时间',
  `effect_tine_end` datetime NOT NULL COMMENT '拦截结束时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

CREATE TABLE `rule_field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table` text NOT NULL COMMENT '表名',
  `name` text NOT NULL COMMENT '字段名',
  `desc` text NOT NULL COMMENT '字段描述',
  `type` text NOT NULL COMMENT '字段类型',
  `enum_values` text COMMENT '枚举值',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

