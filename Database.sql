-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 06, 2024 at 06:20 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlttb`
--

-- --------------------------------------------------------

--
-- Table structure for table `brand`
--

CREATE TABLE `brand` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `show_home` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `brand`
--

INSERT INTO `brand` (`id`, `name`, `show_home`) VALUES
(1, 'Không Có', b'0'),
(2, 'LG', b'0'),
(3, 'Kingston', b'0'),
(4, 'HP', b'0'),
(5, 'Lenovo', b'0'),
(6, 'SamSung', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `show_home` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `description`, `image`, `name`, `show_home`) VALUES
(1, 'ABC', '1.jpg', 'Phần Cứng', b'1'),
(2, 'ABC', '2.jpg', 'Thiết Bị Ngoại Vi', b'1'),
(3, 'ABC', '25.jpg', 'Mạng', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `department_id` bigint NOT NULL,
  `department_name` varchar(50) NOT NULL,
  `location` varchar(255) NOT NULL,
  `show_home` bit(1) NOT NULL,
  `department_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`department_id`, `department_name`, `location`, `show_home`, `department_type_id`) VALUES
(1, 'Phòng CNTT', 'E10.112', b'1', 2);

-- --------------------------------------------------------

--
-- Table structure for table `department_type`
--

CREATE TABLE `department_type` (
  `id` bigint NOT NULL,
  `department_type_name` varchar(50) NOT NULL,
  `show_home` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `department_type`
--

INSERT INTO `department_type` (`id`, `department_type_name`, `show_home`) VALUES
(1, 'Phòng ban CTT', 'Yes'),
(2, 'Phòng ban CNTT', 'Yes'),
(3, 'Phòng Kế Toán', 'Yes'),
(4, 'Phòng Bảo Hiểm', 'Yes'),
(5, 'Phòng Bảo Hiểm', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `employee_code` varchar(255) NOT NULL,
  `employee_name` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `employee_type_id` bigint NOT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `address`, `email`, `employee_code`, `employee_name`, `telephone`, `employee_type_id`, `user_id`) VALUES
(1, '123 Street, City, Country', 'john.doe@example.com', 'EMP001', 'John Doe', '1234567890', 1, 1),
(3, '17', 'dinhnhathai1@gmail.com', 'VS23232', 'Đinh Nhật Hải', '0859330525', 1, 2),
(4, 'TPHCM Q9', 'minh@gmail.com', 'SDF2323', 'Hoàng Minh', '0859330525', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `employee_type`
--

CREATE TABLE `employee_type` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `show_home` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee_type`
--

INSERT INTO `employee_type` (`id`, `description`, `name`, `show_home`) VALUES
(1, 'Trưởng Phòng', 'Trưởng Phòng CNTT', '1'),
(2, '', 'Nhân Viên Kiểm Toán', 'Yes'),
(3, '', 'Nhân Viên Bảo Trì', 'Yes'),
(4, '', 'Phó Phòng CNTT', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `equipment_id` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `name_equipment` varchar(255) NOT NULL,
  `brand_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `status_equipment_id` bigint NOT NULL,
  `status_equipment_type_id` bigint NOT NULL,
  `sub_category_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`id`, `description`, `equipment_id`, `model`, `name_equipment`, `brand_id`, `category_id`, `equipment_type_id`, `status_equipment_id`, `status_equipment_type_id`, `sub_category_id`) VALUES
(1, 'ABC', 'KIOSK', 'WF2032', 'Hệ thống kiosk thanh toán tự động', 1, 1, 1, 2, 3, 1),
(5, '', 'RAM22323', 'RAM22', 'RAM 8GB', 3, 1, 5, 2, 1, 1),
(6, '', 'DA222', 'DSDSD', 'Dây Cáp HDMI', 2, 2, 6, 2, 2, 2),
(7, '', 'KIOSK2', 'WF2032', 'Hệ thống kiosk thanh toán tự động', 3, 1, 1, 1, 2, 1),
(8, '', 'ABC', 'WF2032', 'Màn Hình 24 inch ', 2, 1, 2, 1, 1, 1),
(9, '', 'MX20232', 'WF203223', 'RAM 12GB', 1, 1, 2, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `equipment_type`
--

CREATE TABLE `equipment_type` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `show_home` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `equipment_type`
--

INSERT INTO `equipment_type` (`id`, `description`, `name`, `show_home`) VALUES
(1, 'Đây là mô tả cho Hệ Thống Thiết Bị', 'Hệ Thống Thiết Bị', '1'),
(2, 'Đây là mô tả cho Thiết Bị', 'Thiết Bị', '1'),
(5, '', 'Linh Kiện', 'Yes'),
(6, '', 'Phụ Kiện', 'Yes'),
(7, '', 'Thiết Bị Ngoại Vi', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_type`
--

CREATE TABLE `maintenance_type` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `show_home` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `maintenance_type`
--

INSERT INTO `maintenance_type` (`id`, `description`, `name`, `show_home`) VALUES
(1, '', 'Bảo Trì Hàng Tháng', 'Yes'),
(2, '', 'Bảo Trì Hàng Năm', 'Yes'),
(3, '', 'Bảo Trì Hàng Tháng 2', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id` bigint NOT NULL,
  `date_time` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name_receipt` varchar(255) NOT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` bigint DEFAULT NULL,
  `receipt_id` varchar(255) NOT NULL,
  `employee_id` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  `sub_category_id` bigint NOT NULL,
  `vendor_id` bigint NOT NULL,
  `warehouse_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `replacement_upgrade_ticket`
--

CREATE TABLE `replacement_upgrade_ticket` (
  `id` bigint NOT NULL,
  `action_date` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `original_equipment_name` varchar(255) DEFAULT NULL,
  `received_date` varchar(255) NOT NULL,
  `department_id` bigint NOT NULL,
  `employee_name` bigint NOT NULL,
  `new_equipment_id` bigint NOT NULL,
  `new_equipment_type_id` bigint NOT NULL,
  `original_equipment_id` bigint NOT NULL,
  `original_equipment_type_id` bigint NOT NULL,
  `replacement_upgrade_ticket_type_id` bigint NOT NULL,
  `location_outside` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `replacement_upgrade_ticket_type`
--

CREATE TABLE `replacement_upgrade_ticket_type` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `show_home` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `replacement_upgrade_ticket_type`
--

INSERT INTO `replacement_upgrade_ticket_type` (`id`, `name`, `show_home`) VALUES
(1, 'Nâng Cấp', '1'),
(2, 'Thay Thế', '1');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Table structure for table `status_equipment`
--

CREATE TABLE `status_equipment` (
  `id` bigint NOT NULL,
  `depreciation` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `show_home` varchar(255) NOT NULL,
  `status_equipment_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `status_equipment`
--

INSERT INTO `status_equipment` (`id`, `depreciation`, `description`, `name`, `show_home`, `status_equipment_type_id`) VALUES
(1, 35, '', 'Đang Bị Hư Hại Trả Về Kho', 'Yes', 2),
(2, 10, '', 'Còn Mới Đang Ở Kho Chưa Qua Sử Dụng', 'Yes', 3),
(3, 0, '', 'Đang hoạt động bình thường', 'Yes', 3);

-- --------------------------------------------------------

--
-- Table structure for table `status_equipment_type`
--

CREATE TABLE `status_equipment_type` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `show_home` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `status_equipment_type`
--

INSERT INTO `status_equipment_type` (`id`, `description`, `name`, `show_home`) VALUES
(1, '', 'Đang Hoạt Động', 'Yes'),
(2, '', 'Không Hoạt Động', 'Yes'),
(3, '', 'Đang Sửa Chữa', 'Yes'),
(4, '', 'Đang Hoạt Động 123', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `sub_category`
--

CREATE TABLE `sub_category` (
  `id` bigint NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `show_home` bit(1) DEFAULT NULL,
  `category_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sub_category`
--

INSERT INTO `sub_category` (`id`, `name`, `show_home`, `category_id`) VALUES
(1, 'Máy Tính', b'1', 3),
(2, 'Máy In', b'1', 2),
(3, 'Ổ Cứng', b'1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sub_roles`
--

CREATE TABLE `sub_roles` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `role_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sub_roles`
--

INSERT INTO `sub_roles` (`id`, `name`, `role_id`) VALUES
(1, 'Quản Trị Viên', 1),
(2, 'Nhân Viên Bảo Trì', 2),
(3, 'Nhân Viên Sửa Chữa', 1),
(4, 'Nhân Viên Kế Toán', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint NOT NULL,
  `email` varchar(100) NOT NULL,
  `enable` bit(1) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `employee_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `enable`, `name`, `password`, `username`, `employee_type_id`) VALUES
(1, 'admin@example.com', b'1', 'Trần Văn A', '$2a$10$xdIpTH9WHgV5knR4bxmfleF2UEYTFjJQfgOe2k6xvgCclfF74c4Ca', 'admin', 1),
(2, 'dinhnhathai1@gmail.com', b'1', 'Dinh Hai', '$2a$10$EQiKLmst7hxgjC/NQ4WNduMKhjNJ2OgxPY6lfoUQfnwJz1ELPRnmi', 'dinhnhathai1', 3),
(3, 'minh@gmail.com', b'1', 'Hoàng Minh', '$2a$10$op19AMP5BiB7BYwTtvhlVe8H1LO5DYDdKe9fh.qEV/.nzXo/2YsNi', 'hoangminh1523', 3);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `role_id`, `user_id`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_sub_roles`
--

CREATE TABLE `user_sub_roles` (
  `id` bigint NOT NULL,
  `sub_role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_sub_roles`
--

INSERT INTO `user_sub_roles` (`id`, `sub_role_id`, `user_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id` bigint NOT NULL,
  `address` varchar(100) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `vendor_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id`, `address`, `description`, `email`, `telephone`, `vendor_name`) VALUES
(1, 'VietNam', '', 'dinhnhathai1@gmail.com', '0379198495', 'Ethernet shop'),
(2, 'TPHCM ASDSDB SD SD ASD AS DS DS CSCS DS DS D', '', 'thanh125@gmail.com', '0859330525', 'FPT');

-- --------------------------------------------------------

--
-- Table structure for table `warehouses`
--

CREATE TABLE `warehouses` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `warehouses`
--

INSERT INTO `warehouses` (`id`, `description`, `location`, `name`) VALUES
(1, 'ABC', 'E10.1', 'Kho CNTT'),
(2, 'ABC', 'E10.11', 'Kho CNTT 2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`department_id`),
  ADD KEY `FKlqp34iubxvsqq0169w82fgcrq` (`department_type_id`);

--
-- Indexes for table `department_type`
--
ALTER TABLE `department_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_fopic1oh5oln2khj8eat6ino0` (`email`),
  ADD UNIQUE KEY `UK_70okqib3h08m5eb1jdwld7bu9` (`employee_code`),
  ADD UNIQUE KEY `UK_mpps3d3r9pdvyjx3iqixi96fi` (`user_id`),
  ADD KEY `FKks0jnjwhw9tjwa2b1l0klv1fb` (`employee_type_id`);

--
-- Indexes for table `employee_type`
--
ALTER TABLE `employee_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `equipment`
--
ALTER TABLE `equipment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmxbl1bih3r158nspueyg4ieki` (`brand_id`),
  ADD KEY `FKb4svnpl9s3b1p5uuvqx5ihlki` (`category_id`),
  ADD KEY `FKog1e3ls88y65004cs34gtncgs` (`equipment_type_id`),
  ADD KEY `FKg1hl027r5c9wrsq2tfwc8g0qo` (`status_equipment_id`),
  ADD KEY `FK6w33xbm8ng9jxjrexenksgc14` (`status_equipment_type_id`),
  ADD KEY `FKnv683vl587rwb4no31l47v0fx` (`sub_category_id`);

--
-- Indexes for table `equipment_type`
--
ALTER TABLE `equipment_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maintenance_type`
--
ALTER TABLE `maintenance_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKniyenjjqfhfpa7gc13wwk233f` (`employee_id`),
  ADD KEY `FKs5b506lat7hblcoax5n29t7rr` (`equipment_id`),
  ADD KEY `FKcg0m7rp78i0gp7lj3osqbdnld` (`sub_category_id`),
  ADD KEY `FKbheob2rr9lf7hf47ckd37079k` (`vendor_id`),
  ADD KEY `FKoph7vxqnol9dqc6m8n8vpkgo` (`warehouse_id`);

--
-- Indexes for table `replacement_upgrade_ticket`
--
ALTER TABLE `replacement_upgrade_ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt89tsgf78nb7run4m1hp7vpfp` (`department_id`),
  ADD KEY `FKi088fdkgpu0vigbclarretbvu` (`employee_name`),
  ADD KEY `FKfo66w4jp75qtmmkry4vjx6vf7` (`new_equipment_id`),
  ADD KEY `FKg5ntqdsoo29xtnb6voj7i03qt` (`new_equipment_type_id`),
  ADD KEY `FK79y1c5fdnkeuq5opfmswerkcn` (`original_equipment_id`),
  ADD KEY `FK3i831c0a7cf768tkaeitp6i4l` (`original_equipment_type_id`),
  ADD KEY `FKd8l978di9gcipkbq36u84p22` (`replacement_upgrade_ticket_type_id`);

--
-- Indexes for table `replacement_upgrade_ticket_type`
--
ALTER TABLE `replacement_upgrade_ticket_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`);

--
-- Indexes for table `status_equipment`
--
ALTER TABLE `status_equipment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKasbfh8p9qt0mijvhn23u55ag7` (`status_equipment_type_id`);

--
-- Indexes for table `status_equipment_type`
--
ALTER TABLE `status_equipment_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sub_category`
--
ALTER TABLE `sub_category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl65dyy5me2ypoyj8ou1hnt64e` (`category_id`);

--
-- Indexes for table `sub_roles`
--
ALTER TABLE `sub_roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_1t93spxcuey3vu6ojl1nlgahq` (`name`),
  ADD KEY `FKkiu6e902rcemc0787obfc5ott` (`role_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  ADD UNIQUE KEY `UK_3g1j96g94xpk3lpxl2qbl985x` (`name`),
  ADD UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`),
  ADD KEY `FKiy22pnvnq0g9mud2w259v4wak` (`employee_type_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  ADD KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`);

--
-- Indexes for table `user_sub_roles`
--
ALTER TABLE `user_sub_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjl8n503gssgfp0suab1sol2xh` (`sub_role_id`),
  ADD KEY `FK8dgjp1p23wku266l9mqd4km8n` (`user_id`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_jyjmopegfp4iape655lu75sml` (`email`);

--
-- Indexes for table `warehouses`
--
ALTER TABLE `warehouses`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `department_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `department_type`
--
ALTER TABLE `department_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employee_type`
--
ALTER TABLE `employee_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `equipment_type`
--
ALTER TABLE `equipment_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `maintenance_type`
--
ALTER TABLE `maintenance_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `replacement_upgrade_ticket`
--
ALTER TABLE `replacement_upgrade_ticket`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `replacement_upgrade_ticket_type`
--
ALTER TABLE `replacement_upgrade_ticket_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `status_equipment`
--
ALTER TABLE `status_equipment`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `status_equipment_type`
--
ALTER TABLE `status_equipment_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sub_category`
--
ALTER TABLE `sub_category`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sub_roles`
--
ALTER TABLE `sub_roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user_sub_roles`
--
ALTER TABLE `user_sub_roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `vendor`
--
ALTER TABLE `vendor`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `warehouses`
--
ALTER TABLE `warehouses`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `FKlqp34iubxvsqq0169w82fgcrq` FOREIGN KEY (`department_type_id`) REFERENCES `department_type` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKhal2duyxxjtadykhxos7wd3wg` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKks0jnjwhw9tjwa2b1l0klv1fb` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`);

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `FK6w33xbm8ng9jxjrexenksgc14` FOREIGN KEY (`status_equipment_type_id`) REFERENCES `status_equipment_type` (`id`),
  ADD CONSTRAINT `FKb4svnpl9s3b1p5uuvqx5ihlki` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FKg1hl027r5c9wrsq2tfwc8g0qo` FOREIGN KEY (`status_equipment_id`) REFERENCES `status_equipment` (`id`),
  ADD CONSTRAINT `FKmxbl1bih3r158nspueyg4ieki` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `FKnv683vl587rwb4no31l47v0fx` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`id`),
  ADD CONSTRAINT `FKog1e3ls88y65004cs34gtncgs` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `FKbheob2rr9lf7hf47ckd37079k` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`),
  ADD CONSTRAINT `FKcg0m7rp78i0gp7lj3osqbdnld` FOREIGN KEY (`sub_category_id`) REFERENCES `sub_category` (`id`),
  ADD CONSTRAINT `FKniyenjjqfhfpa7gc13wwk233f` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKoph7vxqnol9dqc6m8n8vpkgo` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouses` (`id`),
  ADD CONSTRAINT `FKs5b506lat7hblcoax5n29t7rr` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `replacement_upgrade_ticket`
--
ALTER TABLE `replacement_upgrade_ticket`
  ADD CONSTRAINT `FK3i831c0a7cf768tkaeitp6i4l` FOREIGN KEY (`original_equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FK79y1c5fdnkeuq5opfmswerkcn` FOREIGN KEY (`original_equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FKd8l978di9gcipkbq36u84p22` FOREIGN KEY (`replacement_upgrade_ticket_type_id`) REFERENCES `replacement_upgrade_ticket_type` (`id`),
  ADD CONSTRAINT `FKfo66w4jp75qtmmkry4vjx6vf7` FOREIGN KEY (`new_equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FKg5ntqdsoo29xtnb6voj7i03qt` FOREIGN KEY (`new_equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FKi088fdkgpu0vigbclarretbvu` FOREIGN KEY (`employee_name`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKt89tsgf78nb7run4m1hp7vpfp` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`);

--
-- Constraints for table `status_equipment`
--
ALTER TABLE `status_equipment`
  ADD CONSTRAINT `FKasbfh8p9qt0mijvhn23u55ag7` FOREIGN KEY (`status_equipment_type_id`) REFERENCES `status_equipment_type` (`id`);

--
-- Constraints for table `sub_category`
--
ALTER TABLE `sub_category`
  ADD CONSTRAINT `FKl65dyy5me2ypoyj8ou1hnt64e` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `sub_roles`
--
ALTER TABLE `sub_roles`
  ADD CONSTRAINT `FKkiu6e902rcemc0787obfc5ott` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKiy22pnvnq0g9mud2w259v4wak` FOREIGN KEY (`employee_type_id`) REFERENCES `employee_type` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_sub_roles`
--
ALTER TABLE `user_sub_roles`
  ADD CONSTRAINT `FK8dgjp1p23wku266l9mqd4km8n` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKjl8n503gssgfp0suab1sol2xh` FOREIGN KEY (`sub_role_id`) REFERENCES `sub_roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
