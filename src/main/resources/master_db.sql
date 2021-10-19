create database master_db;
CREATE TABLE  `master_db`.`tbl_tenant_master` (
  `tenant_client_id` int(10) unsigned NOT NULL,
  `db_name` varchar(50) NOT NULL,
  `url` varchar(100) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `driver_class` varchar(100) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`tenant_client_id`) USING BTREE
) ENGINE=InnoDB;


INSERT INTO master_db.tbl_tenant_master VALUES (200,"vw","jdbc:mysql://localhost:3306/vw?useSSL=false","root","admin","com.mysql.cj.jdbc.Driver","Active")
