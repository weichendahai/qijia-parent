/*

资源:
  表示菜单元素、页面按钮元素等;菜单元素用来显示界面菜单的，页面按钮是每个页面可进行的操作，
  如 新增、修改、删除按钮;使用 type 来区分元素类型(如 menu 表示菜单，button 代表按钮)，
  priority 是元素 的排序，如菜单显示顺序;
  permission 表示权限;
  如用户菜单使用 user:* ;也就是把菜单授权给用户后，用户 就拥有了 user:* 权限;
  如用户新增按钮使用 user:create，也就是把用户新增按钮授权给用户后，用户就拥有了 user:create 权限了;
  available 表示资源是否可用，如菜单显示 / 不显示。

角色:
  role 表示角色标识符，如 admin，用于后台判断使用;
  description 表示角色描述，如超级管理员，用于 前端显示给用户使用;
  resource_ids 表示该角色拥有的资源列表，即该角色拥有的权限列表(显示角色)，即角 色是权限字符串集合;
  available 表示角色是否可用。

组织机构:
  name 表示组织机构名称，
  priority 是组织机构的排序，即显示顺序;
  available 表示组织机构是否可 用。

用户:
  username 表示用户名;password 表示密码;
  salt 表示加密密码的盐;
  role_ids 表示用户拥有的角色列表，可以通过角色再获取其权限字符串列表;
  locked 表示用户是否锁定。

 */

drop table if exists sys_user;
drop table if exists sys_organization;
drop table if exists sys_resource;
drop table if exists sys_role;

create table sys_user (
  id bigint auto_increment,
  organization_id bigint,
  username varchar(100),
  password varchar(100),
  salt varchar(100),
  role_ids varchar(100),
  locked bool default false,
  constraint pk_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_user_username on sys_user(username);
create index idx_sys_user_organization_id on sys_user(organization_id);

create table sys_organization (
  id bigint auto_increment,
  name varchar(100),
  parent_id bigint,
  parent_ids varchar(100),
  available bool default false,
  constraint pk_sys_organization primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_organization_parent_id on sys_organization(parent_id);
create index idx_sys_organization_parent_ids on sys_organization(parent_ids);


create table sys_resource (
  id bigint auto_increment,
  name varchar(100),
  type varchar(50),
  url varchar(200),
  parent_id bigint,
  parent_ids varchar(100),
  permission varchar(100),
  available bool default false,
  constraint pk_sys_resource primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_resource_parent_id on sys_resource(parent_id);
create index idx_sys_resource_parent_ids on sys_resource(parent_ids);

create table sys_role (
  id bigint auto_increment,
  role varchar(100),
  description varchar(100),
  resource_ids varchar(100),
  available bool default false,
  constraint pk_sys_role primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_role_resource_ids on sys_role(resource_ids);