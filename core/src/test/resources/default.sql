
INSERT INTO nv_user_account
(
    acnt_id, acnt_namespace, acnt_type, acnt_status, acnt_login, acnt_pwd
, acnt_join_type, acnt_locked, acnt_locked_dt, acnt_expired, acnt_disabled, acnt_id_veri, acnt_name_veri
, acnt_dormant_alerted, acnt_dormant, acnt_close_alerted, acnt_close_self, acnt_close, acnt_pwd_change_dt
, acnt_deleted, acnt_created_dt, acnt_created_by, acnt_modified_dt, acnt_modified_by)
VALUES ( -1, 'default', 'a', null, 'system', '$2a$10$b./TNPxsom5GKB5EIyF2AesEHIA678xGQ1kd3cq.M4WGqgifCn2Fy'
       , 'g', false, null, false, false, false, false
       , false, false, false, false, false, NOW()
       , false, NOW(), -1, NOW(), -1);

INSERT INTO nv_user_account
(
    acnt_id, acnt_namespace, acnt_type, acnt_status, acnt_login, acnt_pwd
, acnt_join_type, acnt_locked, acnt_locked_dt, acnt_expired, acnt_disabled, acnt_id_veri, acnt_name_veri
, acnt_dormant_alerted, acnt_dormant, acnt_close_alerted, acnt_close_self, acnt_close, acnt_pwd_change_dt
, acnt_deleted, acnt_created_dt, acnt_created_by, acnt_modified_dt, acnt_modified_by)
VALUES ( 1, 'default', 'a', null, 'admin', '$2a$10$b./TNPxsom5GKB5EIyF2AesEHIA678xGQ1kd3cq.M4WGqgifCn2Fy'
       , 'g', false, null, false, false, false, false
       , false, false, false, false, false, NOW()
       , false, NOW(), -1, NOW(), -1);

INSERT INTO iflexdb.nv_user (user_id, user_name, user_gender)
VALUES ( -1, 'System', 'f');

INSERT INTO iflexdb.nv_user (user_id, user_name, user_gender)
VALUES ( 1, 'Administrator', 'm');
