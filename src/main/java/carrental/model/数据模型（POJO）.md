## 1) `carrental.model` — 数据模型（POJO）

**一句话定位**：存放所有实体类（Plain Old Java Objects），只包含字段、getter/setter 与最少的领域方法（如 `calculateFee()`）。

**职责**

* 定义数据库表对应的 Java 对象结构（User, Car, Customer, Rental, SystemLog）
* 作为 DAO 与 Service 间的数据载体（DTO）
* 所有字段使用私有访问并提供 getter/setter，避免业务逻辑出现在 model 中

**常见类 / 方法**

* `User`（getId/ setUsername / getRole）
* `Car`（getLicensePlate / setStatus）
* `Customer`（getName / getPhone）
* `Rental`（getStartDate / setActualEndDate / calculateFee() — 如果要放方法）
* `SystemLog`（构造日志记录）

**注意事项**

* 不在 model 中放数据库操作或 UI 逻辑
* 字段类型尽量用明确类型（`LocalDate`、`BigDecimal`、`enum` status）
* 如果要序列化到 JSON 或 DB，请保留无参构造

**package-info.java 模板（复制到 `src/main/java/carrental/model/package-info.java`）**

```java
/**
 * carrental.model
 *
 * 说明：
 * 该包包含系统的实体数据类（POJO）。每个类对应一张数据库表或一类业务实体，
 * 仅负责保存数据（字段、getter、setter），并可包含少量纯领域方法（例如费用计算）。
 *
 * 设计要点：
 * - 不在此包放数据库访问或 UI 逻辑（那些职责在 dao / service / ui 中）
 * - 建议使用强类型：LocalDate, BigDecimal, enum 等
 * - 保持类简单、易序列化（提供无参构造）
 *
 * 常见类：
 * - User, Car, Customer, Rental, SystemLog
 */
package carrental.model;
```
