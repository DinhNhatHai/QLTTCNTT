-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 23, 2024 at 11:51 AM
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
-- Database: `qlttb2`
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
(4, '', 'linh-kien-may-tinh.jpg', 'Linh kiện máy tính', b'1'),
(5, '', 'thiet-bi-van-phong.png', 'Thiết bị văn phòng', b'1'),
(6, '', 'thiet-bi-ngoai-vi.jpg', 'Thiết bị ngoại vi', b'1'),
(7, '', 'thiet-bi-mang.jpg', 'Thiết bị mạng', b'1'),
(8, '', 'server.jpg', 'Thiết bị chuyên dụng', b'1'),
(9, '', 'phu-kien.jpg', 'Phụ kiện máy tính', b'1'),
(10, '', 'man-hinh.jpg', 'Màn hình máy tính', b'1'),
(11, '', 'lap-top.jpg', 'Laptop', b'1'),
(12, '', 'pc.jpg', 'Máy tính bàn', b'1'),
(13, '', 'phu-kien-2.jpg', 'Phụ kiện', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `delivery_bill`
--

CREATE TABLE `delivery_bill` (
  `id` bigint NOT NULL,
  `delivery_bill_id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity` bigint NOT NULL,
  `send_date` varchar(255) NOT NULL,
  `department_id` bigint NOT NULL,
  `employee_id` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `warehouse_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
(1, 'Phòng CNTT', 'E10.112', b'1', 2),
(2, 'Phòng Kế Toán', 'E10.12', b'1', 3);

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
(1, '123 Street, City, Country', 'john.doe@example.com', 'EMP001', 'Xuân Phát', '1234567890', 1, 1),
(3, '17', 'dinhnhathai1@gmail.com', 'VS23232', 'Đinh Nhật Hải', '0859330525', 1, 2);

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
(3, '', 'Nhân Viên Bảo Trì', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

CREATE TABLE `equipment` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `name_equipment` varchar(255) NOT NULL,
  `serial_number` varchar(255) NOT NULL,
  `brand_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `receipt_id` bigint DEFAULT NULL,
  `status_equipment_id` bigint NOT NULL,
  `status_equipment_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `equipment`
--

INSERT INTO `equipment` (`id`, `description`, `model`, `name_equipment`, `serial_number`, `brand_id`, `category_id`, `equipment_type_id`, `receipt_id`, `status_equipment_id`, `status_equipment_type_id`) VALUES
(1, 'abcscscscsc', 'WF2032232323', 'RAM 8GB KINGSTON', 'RAM22XCS22', 2, 4, 1, NULL, 4, 5),
(2, '', '231FDVĐCDC', 'Card màn hình ZOTAC 4GB', 'ZOTAC24GB', 3, 4, 8, NULL, 1, 1),
(3, '', 'RAM232', 'Ổ cứng HHD 2TB2', 'HHD2423232222', 3, 4, 5, NULL, 4, 5),
(23, NULL, '222', 'CPU I5 10300H', '242ABCS22', 4, 4, 1, NULL, 1, 1),
(25, NULL, '222', 'CPU I5 10300H', '242ABCS22222', 2, 4, 1, NULL, 1, 1),
(26, NULL, 'CSSS', 'CPU I5 103002222H', 'AAAAA', 4, 4, 1, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `equipment_repair_ticket`
--

CREATE TABLE `equipment_repair_ticket` (
  `id` bigint NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `complete_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `equipment_repair_ticket_id` varchar(255) DEFAULT NULL,
  `processing_time` varchar(255) DEFAULT NULL,
  `received_date` varchar(255) DEFAULT NULL,
  `repair_place` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `equipment_repair_ticket`
--

INSERT INTO `equipment_repair_ticket` (`id`, `comment`, `complete_date`, `description`, `equipment_repair_ticket_id`, `processing_time`, `received_date`, `repair_place`, `department_id`, `employee_id`, `equipment_id`, `equipment_type_id`) VALUES
(1, '23232323232', '17/06/2024 | 08:58', 'abc', 'Phiếu sửa chữa ram 8gb ', '13 ngày 1 giờ 17 phút', '04/06/2024 | 07:41', 'Phòng CNTT', 2, 1, 1, 1),
(2, '12312312323', '17/06/2024 | 09:09', '12312312323', 'Phiếu sửa chữa ram 12gb ', '2 tháng 7 ngày 23 phút', '11/04/2024 | 08:46', 'Phòng CNTT', 1, 1, 2, 1),
(3, '<p>ABC</p>', '17/06/2024 | 14:21', 'abc', 'Phiếu sửa chữa ram 8gb ', '12 ngày 0 phút', '05/06/2024 | 14:21', 'Phòng CNTT', 2, 3, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `equipment_type`
--

CREATE TABLE `equipment_type` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `show_home` varchar(255) NOT NULL,
  `category_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `equipment_type`
--

INSERT INTO `equipment_type` (`id`, `description`, `name`, `show_home`, `category_id`) VALUES
(1, '', 'CPU - Bộ vi xử lý', 'Yes', 4),
(2, '', 'Mainboard - Bo mạch chủ', 'Yes', 4),
(3, '', 'RAM PC', 'Yes', 4),
(4, '', 'RAM Laptop', 'Yes', 4),
(5, '', 'Ổ cứng', 'Yes', 4),
(6, '', 'PSU - Nguồn máy tính', 'Yes', 4),
(7, '', 'Case - Thùng máy tính', 'Yes', 4),
(8, '', 'VGA - Card màn hình', 'Yes', 4),
(9, '', 'Máy in văn phòng', 'Yes', 5);

-- --------------------------------------------------------

--
-- Table structure for table `guarantee`
--

CREATE TABLE `guarantee` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `guarantee_id` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) NOT NULL,
  `warranty_period` varchar(255) NOT NULL,
  `equipment_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `vendor_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `maintenance`
--

CREATE TABLE `maintenance` (
  `id` bigint NOT NULL,
  `cost` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `processing_time` varchar(255) NOT NULL,
  `received_date` varchar(255) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `employee_name` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `maintenance_description_id` bigint NOT NULL,
  `maintenance_schedule_id` bigint DEFAULT NULL,
  `maintenance_status_id` bigint NOT NULL,
  `maintenance_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_description`
--

CREATE TABLE `maintenance_description` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `show_home` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `maintenance_description`
--

INSERT INTO `maintenance_description` (`id`, `description`, `name`, `show_home`) VALUES
(1, 'Hoạt động bảo trì định kỳ hàng năm cho các trang thiết bị CNTT', 'Bảo Trì Hàng Năm', '1'),
(2, 'Hoạt động bảo trì hàng tháng cho các trang thiết bị CNTT', 'Bảo Trì Định Kỳ', '1');

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_plan`
--

CREATE TABLE `maintenance_plan` (
  `id` bigint NOT NULL,
  `cost` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `processing_time` varchar(255) NOT NULL,
  `received_date` varchar(255) NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `employee_name` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `maintenance_description_id` bigint NOT NULL,
  `maintenance_schedule_id` bigint DEFAULT NULL,
  `maintenance_status_id` bigint NOT NULL,
  `maintenance_type_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_schedule`
--

CREATE TABLE `maintenance_schedule` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) NOT NULL,
  `show_home` varchar(255) NOT NULL,
  `start_date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `maintenance_schedule`
--

INSERT INTO `maintenance_schedule` (`id`, `description`, `end_date`, `show_home`, `start_date`) VALUES
(1, '', '12/06/2024 | 16:16', 'Yes', '10/06/2024 | 16:16'),
(2, '', '13/06/2024 | 16:16', 'Yes', '14/06/2024 | 16:16'),
(5, '', '19/06/2024 | 16:16', 'Yes', '15/06/2024 | 16:16'),
(6, '', '21/06/2024 | 16:17', 'Yes', '17/06/2024 | 16:17');

-- --------------------------------------------------------

--
-- Table structure for table `maintenance_status`
--

CREATE TABLE `maintenance_status` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name_status` varchar(50) NOT NULL,
  `show_home` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `maintenance_status`
--

INSERT INTO `maintenance_status` (`id`, `description`, `name_status`, `show_home`) VALUES
(1, '', 'Tạm hoãn', '1'),
(2, '', 'Đang thực hiện', '1'),
(3, '', 'Đang lên kế hoạch', '1'),
(4, '', 'Đã hủy ', '1'),
(5, '', 'Đang chờ thực hiện', '1'),
(6, '', 'Đã hoàn thành bảo trì', '1');

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
(1, '', 'Bảo Trì Hàng Năm', 'Yes'),
(2, '', 'Bảo trì định kỳ', 'Yes'),
(3, '', 'Bảo Trì Hàng Năm 2', 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

CREATE TABLE `receipt` (
  `id` bigint NOT NULL,
  `date_add` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `quantity` bigint NOT NULL,
  `receipt_code` varchar(255) NOT NULL,
  `employee_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
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
  `location_outside` varchar(255) DEFAULT NULL,
  `original_equipment_name` varchar(255) DEFAULT NULL,
  `received_date` varchar(255) NOT NULL,
  `department_id` bigint NOT NULL,
  `employee_name` bigint NOT NULL,
  `new_equipment_id` bigint NOT NULL,
  `new_equipment_type_id` bigint NOT NULL,
  `original_equipment_id` bigint NOT NULL,
  `original_equipment_type_id` bigint NOT NULL,
  `replacement_upgrade_ticket_type_id` bigint NOT NULL
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
(1, 'Nâng cấp', '0'),
(2, 'Thay thế', '1');

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
(3, 0, '', 'Đang hoạt động bình thường', 'Yes', 3),
(4, 0, '', 'Mới 100%', 'Yes', 5);

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
(1, '', 'Đang hoạt động', 'Yes'),
(2, '', 'Không hoạt động', 'Yes'),
(3, '', 'Đang Sửa Chữa', 'Yes'),
(4, '', 'Đang Hoạt Động 123', 'Yes'),
(5, '', 'Mới Nhập Hàng', 'Yes');

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
(1, 'VietNam', '', 'dinhnhathai1@gmail.com', '0379198495', 'FPT');

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
(1, '', 'E10.112', 'Kho CNTT');

-- --------------------------------------------------------

--
-- Table structure for table `warranty`
--

CREATE TABLE `warranty` (
  `id` bigint NOT NULL,
  `date_return` varchar(255) DEFAULT NULL,
  `date_take` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `warranty_id` varchar(255) NOT NULL,
  `employee_id` bigint NOT NULL,
  `equipment_id` bigint NOT NULL,
  `equipment_type_id` bigint NOT NULL,
  `guarantee_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
-- Indexes for table `delivery_bill`
--
ALTER TABLE `delivery_bill`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_f99xq6cbf0j6lf20wnyjb6foo` (`equipment_id`),
  ADD KEY `FK572mfx1ctwyt7qkyhbsn8fywm` (`department_id`),
  ADD KEY `FK1071msftjrrkg0c1cip27re5g` (`employee_id`),
  ADD KEY `FK3wpmnsnpii8tfgp9pvexchvgu` (`equipment_type_id`),
  ADD KEY `FKn0aubejyh9apcg2gw5el2p64o` (`warehouse_id`);

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
  ADD UNIQUE KEY `UK_agm98wn5ln6uoh6o9hx25ogic` (`serial_number`),
  ADD KEY `FKmxbl1bih3r158nspueyg4ieki` (`brand_id`),
  ADD KEY `FKb4svnpl9s3b1p5uuvqx5ihlki` (`category_id`),
  ADD KEY `FKog1e3ls88y65004cs34gtncgs` (`equipment_type_id`),
  ADD KEY `FKi5cx88knoq3ao8ov3sa4deuh0` (`receipt_id`),
  ADD KEY `FKg1hl027r5c9wrsq2tfwc8g0qo` (`status_equipment_id`),
  ADD KEY `FK6w33xbm8ng9jxjrexenksgc14` (`status_equipment_type_id`);

--
-- Indexes for table `equipment_repair_ticket`
--
ALTER TABLE `equipment_repair_ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK9o9qjt2aiuryehjsbkuy9fv2c` (`department_id`),
  ADD KEY `FKj5tlhks7druy3w102q1taugld` (`employee_id`),
  ADD KEY `FKa968m2p0tqq3qn0pgw4efc0xv` (`equipment_id`),
  ADD KEY `FKfdra6wk9koy77dol0im32gb51` (`equipment_type_id`);

--
-- Indexes for table `equipment_type`
--
ALTER TABLE `equipment_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnljjekkjr2h3r4ss7l850hv27` (`category_id`);

--
-- Indexes for table `guarantee`
--
ALTER TABLE `guarantee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_7hew9mr6apw9wida62h8heeeq` (`equipment_id`),
  ADD KEY `FKo8r39vg75f7lohrnf1tddlwpp` (`equipment_type_id`),
  ADD KEY `FKmmwlqnhclqeijsbpucl5w271r` (`vendor_id`);

--
-- Indexes for table `maintenance`
--
ALTER TABLE `maintenance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs1lrka60enmgxme636dpem86d` (`employee_name`),
  ADD KEY `FK2aup8ahw6qoupvcgcktsjdvbf` (`equipment_id`),
  ADD KEY `FK9et3srofnjwdlxm0f1cknx3bl` (`equipment_type_id`),
  ADD KEY `FKmocyj87wbei9ajj0qbde51eac` (`maintenance_description_id`),
  ADD KEY `FKjhv24uqg3raym94yv9w4b3kjk` (`maintenance_schedule_id`),
  ADD KEY `FK3fl2bpy2mgbefe8jvwxqo8b9` (`maintenance_status_id`),
  ADD KEY `FKgqphq56s0igxcc4pvpgy2bg30` (`maintenance_type_id`);

--
-- Indexes for table `maintenance_description`
--
ALTER TABLE `maintenance_description`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maintenance_plan`
--
ALTER TABLE `maintenance_plan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrh4dpn59qx6ksl15ee9jpuxut` (`employee_name`),
  ADD KEY `FK33en8npmnb2cyn8kofkcrppr1` (`equipment_id`),
  ADD KEY `FKomp9urdb0mig3f7jrm7v5ufph` (`equipment_type_id`),
  ADD KEY `FKtaj0p7fb5rnxawyh42vb79hkf` (`maintenance_description_id`),
  ADD KEY `FKleb3f61ydx4hvpprupc9ki3ti` (`maintenance_schedule_id`),
  ADD KEY `FK5jb181538oiek57o3kmi7etbw` (`maintenance_status_id`),
  ADD KEY `FK5e3vv35jsbesgxpxijsmbw2dh` (`maintenance_type_id`);

--
-- Indexes for table `maintenance_schedule`
--
ALTER TABLE `maintenance_schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `maintenance_status`
--
ALTER TABLE `maintenance_status`
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
  ADD KEY `FK6y9mxpj90tithrwh7uta1dhve` (`equipment_type_id`),
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
-- Indexes for table `warranty`
--
ALTER TABLE `warranty`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_fomnoath8n66sw4rtdo6mujrf` (`equipment_id`),
  ADD KEY `FKc959j87bgeuyqlpy63yxr2npt` (`employee_id`),
  ADD KEY `FKfgkeebma6r3yce28ktphcqasb` (`equipment_type_id`),
  ADD KEY `FKr1bsjm6u7cg8di2wlp8r78q74` (`guarantee_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brand`
--
ALTER TABLE `brand`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `delivery_bill`
--
ALTER TABLE `delivery_bill`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `department_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `department_type`
--
ALTER TABLE `department_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `employee_type`
--
ALTER TABLE `employee_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `equipment`
--
ALTER TABLE `equipment`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `equipment_repair_ticket`
--
ALTER TABLE `equipment_repair_ticket`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `equipment_type`
--
ALTER TABLE `equipment_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `guarantee`
--
ALTER TABLE `guarantee`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance`
--
ALTER TABLE `maintenance`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance_description`
--
ALTER TABLE `maintenance_description`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `maintenance_plan`
--
ALTER TABLE `maintenance_plan`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance_schedule`
--
ALTER TABLE `maintenance_schedule`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `maintenance_status`
--
ALTER TABLE `maintenance_status`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

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
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `status_equipment_type`
--
ALTER TABLE `status_equipment_type`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `warehouses`
--
ALTER TABLE `warehouses`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `warranty`
--
ALTER TABLE `warranty`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `delivery_bill`
--
ALTER TABLE `delivery_bill`
  ADD CONSTRAINT `FK1071msftjrrkg0c1cip27re5g` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FK3wpmnsnpii8tfgp9pvexchvgu` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FK572mfx1ctwyt7qkyhbsn8fywm` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  ADD CONSTRAINT `FKn0aubejyh9apcg2gw5el2p64o` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouses` (`id`),
  ADD CONSTRAINT `FKtopvrlomyk14oyn679tchiyoh` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

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
  ADD CONSTRAINT `FKi5cx88knoq3ao8ov3sa4deuh0` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`),
  ADD CONSTRAINT `FKmxbl1bih3r158nspueyg4ieki` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `FKog1e3ls88y65004cs34gtncgs` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`);

--
-- Constraints for table `equipment_repair_ticket`
--
ALTER TABLE `equipment_repair_ticket`
  ADD CONSTRAINT `FK9o9qjt2aiuryehjsbkuy9fv2c` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`),
  ADD CONSTRAINT `FKa968m2p0tqq3qn0pgw4efc0xv` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FKfdra6wk9koy77dol0im32gb51` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FKj5tlhks7druy3w102q1taugld` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `equipment_type`
--
ALTER TABLE `equipment_type`
  ADD CONSTRAINT `FKnljjekkjr2h3r4ss7l850hv27` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `guarantee`
--
ALTER TABLE `guarantee`
  ADD CONSTRAINT `FK75h37a4yptsc3a4n4k6t6jw1d` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FKmmwlqnhclqeijsbpucl5w271r` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`),
  ADD CONSTRAINT `FKo8r39vg75f7lohrnf1tddlwpp` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`);

--
-- Constraints for table `maintenance`
--
ALTER TABLE `maintenance`
  ADD CONSTRAINT `FK2aup8ahw6qoupvcgcktsjdvbf` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FK3fl2bpy2mgbefe8jvwxqo8b9` FOREIGN KEY (`maintenance_status_id`) REFERENCES `maintenance_status` (`id`),
  ADD CONSTRAINT `FK9et3srofnjwdlxm0f1cknx3bl` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FKgqphq56s0igxcc4pvpgy2bg30` FOREIGN KEY (`maintenance_type_id`) REFERENCES `maintenance_type` (`id`),
  ADD CONSTRAINT `FKjhv24uqg3raym94yv9w4b3kjk` FOREIGN KEY (`maintenance_schedule_id`) REFERENCES `maintenance_schedule` (`id`),
  ADD CONSTRAINT `FKmocyj87wbei9ajj0qbde51eac` FOREIGN KEY (`maintenance_description_id`) REFERENCES `maintenance_description` (`id`),
  ADD CONSTRAINT `FKs1lrka60enmgxme636dpem86d` FOREIGN KEY (`employee_name`) REFERENCES `employee` (`id`);

--
-- Constraints for table `maintenance_plan`
--
ALTER TABLE `maintenance_plan`
  ADD CONSTRAINT `FK33en8npmnb2cyn8kofkcrppr1` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FK5e3vv35jsbesgxpxijsmbw2dh` FOREIGN KEY (`maintenance_type_id`) REFERENCES `maintenance_type` (`id`),
  ADD CONSTRAINT `FK5jb181538oiek57o3kmi7etbw` FOREIGN KEY (`maintenance_status_id`) REFERENCES `maintenance_status` (`id`),
  ADD CONSTRAINT `FKleb3f61ydx4hvpprupc9ki3ti` FOREIGN KEY (`maintenance_schedule_id`) REFERENCES `maintenance_schedule` (`id`),
  ADD CONSTRAINT `FKomp9urdb0mig3f7jrm7v5ufph` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FKrh4dpn59qx6ksl15ee9jpuxut` FOREIGN KEY (`employee_name`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKtaj0p7fb5rnxawyh42vb79hkf` FOREIGN KEY (`maintenance_description_id`) REFERENCES `maintenance_description` (`id`);

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `FK6y9mxpj90tithrwh7uta1dhve` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FKbheob2rr9lf7hf47ckd37079k` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`id`),
  ADD CONSTRAINT `FKniyenjjqfhfpa7gc13wwk233f` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKoph7vxqnol9dqc6m8n8vpkgo` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouses` (`id`);

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

--
-- Constraints for table `warranty`
--
ALTER TABLE `warranty`
  ADD CONSTRAINT `FKc959j87bgeuyqlpy63yxr2npt` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  ADD CONSTRAINT `FKd0oey48k7skpstbomamgspsre` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`),
  ADD CONSTRAINT `FKfgkeebma6r3yce28ktphcqasb` FOREIGN KEY (`equipment_type_id`) REFERENCES `equipment_type` (`id`),
  ADD CONSTRAINT `FKr1bsjm6u7cg8di2wlp8r78q74` FOREIGN KEY (`guarantee_id`) REFERENCES `guarantee` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
