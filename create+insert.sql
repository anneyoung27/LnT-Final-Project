CREATE DATABASE pudding;
USE pudding;
CREATE TABLE Users (
	userID CHAR(5) NOT NULL,
    userName VARCHAR(30) NOT NULL,
    userPassword VARCHAR(30) NOT NULL,
    PRIMARY KEY(userID));
    
CREATE TABLE Menu (
	menuID CHAR(5) NOT NULL,
    namaMenu VARCHAR(30) NOT NULL,
    hargaMenu INT NOT NULL,
    stokMenu INT NOT NULL,
    PRIMARY KEY(menuID));
    
CREATE TABLE HeaderTransaction (
	transactionID CHAR(5) NOT NULL,
    userID CHAR(5) DEFAULT NULL,
    transactionDate DATE,
    PRIMARY KEY(transactionID),
    FOREIGN KEY(userID) REFERENCES Users(userID) ON UPDATE CASCADE);
    
CREATE TABLE DetailTransaction (
	transactionID CHAR(5) NOT NULL,
    menuID CHAR(5) NOT NULL,
    qty INT DEFAULT NULL,
    PRIMARY KEY(transactionID, menuID),
    FOREIGN KEY(transactionID) REFERENCES HeaderTransaction(transactionID) ON UPDATE CASCADE,
    FOREIGN KEY(menuID) REFERENCES Menu(menuID) ON UPDATE CASCADE);
    
-- Insert data.
INSERT INTO Users(userID, userName, userPassword)
VALUES('US001', 'user', 'user123');

INSERT INTO Menu(menuID, namaMenu, hargaMenu, stokMenu)
VALUES('PD001', 'Black Pudding', 40000, 120),
('PD002', 'Spring Pudding', 120000, 32),
('PD003', 'Matcha Pudding', 90000, 89);

INSERT INTO HeaderTransaction(transactionID, userID, transactionDate)
VALUES('TR001', 'US001', '2022-05-21'),
('TR002', 'US001', '2022-05-28');

INSERT INTO DetailTransaction(transactionID, menuID, qty)
VALUES('TR001','PD001',10),
('TR001','PD002', 5),
('TR002', 'PD001', 3),
('TR002','PD003', 6);
