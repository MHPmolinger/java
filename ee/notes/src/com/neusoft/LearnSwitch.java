package com.neusoft;

public class LearnSwitch {
/*
 chapter 04选择结构(二)

本章主要讲解switch结构

一、为什么要使用switch结构？
当判断等值区间的问题时，我们可以使用第三章中的多重if完成，但是多重if
判断等值区间的问题时，结构比较复杂，代码冗余，所以这时使用switch结构更为简洁。
二、如何使用switch？
1.语法：
 switch(区间的值){
   case 常量值1:
     要执行的代码;
     [break;]
   case 常量值2:
      要执行的代码;
      [break;]
    default:
      要执行的代码;
      [break;]
 }
 解释：在switch()中，要放入的数据类型常用的就是int类型。但是在jdk7以上版本中加入
       了String类型。语法就是可以有int/char/String
 注意：
 1.在switch()中只能有三种数据类型int,char,String[在JDK7.0后的新特性]     
 2.在switch中的case的常量不允许重复。
三、switch结构的特点
   1.根据switch中的值，去定位相应的case。所以执行的速度要比多重if稍快。
   2.不像多重if，判断顺序放生改变而结果改变。
   3.如果case中的没有break，那么会贯穿其它case，直到遇到break，或该结构执行完毕。
四、选择结构总结
1.if选择结构
	基本if选择结构： 处理单一或组合条件的情况
	If-else选择结构：处理简单的条件分支情况
	多重if选择结构：处理复杂的条件分支情况
	嵌套if选择结构：用于较为复杂的流程控制
2.switch选择结构
	多重分支并且条件判断是等值判断的情况
 */
}
