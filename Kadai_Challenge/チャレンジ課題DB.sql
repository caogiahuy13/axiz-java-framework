-- 1. axizdb_task�f�[�^�x�[�X�̍쐬		
		
	CREATE DATABASE axizdb_task;	
		
-- 2. role�e�[�u���̍쐬		
		
	CREATE TABLE role (	
		role_id INT PRIMARY KEY,
		role_name VARCHAR(50)
	);	
		
-- 3. role���o�^		
		
	INSERT INTO role (role_id, role_name) VALUES	
		(1, '�Ǘ���'),
		(2, '���');
		
-- 4. user_info�e�[�u���̍쐬	
	CREATE OR REPLACE FUNCTION update_datetime_column() 
	RETURNS TRIGGER AS '
	BEGIN
	    NEW.update_datetime = now();
	    RETURN NEW; 
	END;
	' language 'plpgsql';

	CREATE TABLE user_info (	
		user_id SERIAL PRIMARY KEY,
		login_id VARCHAR(50) UNIQUE,
		user_name VARCHAR(50),
		telephone VARCHAR(50),
		password  VARCHAR(50),
		role_id INT NOT NULL REFERENCES role(role_id),
		create_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	);	
	
	CREATE TRIGGER set_timestamp
	BEFORE UPDATE ON user_info
	FOR EACH ROW
	EXECUTE PROCEDURE update_datetime_column();

		
-- 5. �V�[�P���X�ԍ��̏����l�ݒ�		
		
	ALTER SEQUENCE user_info_user_id_seq RESTART 101;	
		
-- 6. user_info���o�^		
		
	INSERT INTO user_info (login_id, user_name, telephone, password, role_id, create_datetime, update_datetime) VALUES	
		('sato', '����', '09011111111', 'axiz',1, NOW(), NOW()),
		('suzuki', '���', '09022222222', 'bxiz',1, NULL, NULL),
		('takahashi', '����', '09033333333', 'cxiz',1, NOW(), NOW()),
		('tanaka', '�c��', '09044444444', 'dxiz', 2, NOW(), NOW()),
		('ito', '�ɓ�', '09055555555', 'exiz', 2, NOW(), NOW()),
		('yamamoto', '�R�{', '09066666666', 'fxiz', 2, NOW(), NOW()),
		('watanabe', '�n��', '09077777777', 'gxiz', 2, NOW(), NOW()),
		('nakamura', '����', '09088888888', 'hxiz', 2, NOW(), NOW()),
		('kobayashi', '����', '09099999999', 'ixiz', 2, NOW(), NOW()),
		('kato', '����', '09000000000', 'jxiz', 2, NOW(), NOW());
		

