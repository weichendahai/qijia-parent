# shop-admin-model


## 说明
```
model模块: po对象，与数据库表一一对应，可以增加关联对象的属性，方便返回数据，
如订单表关联订单明细表的多条数据，则订单类里可以增加一个订单明细的List属性，
但严禁增加查询条件，所有查询均使用conditions包对应的对象作为查询条件
（只有一个查询条件的可以直接以条件作为参数，如select(long id)、select(UserCondition condition）
```