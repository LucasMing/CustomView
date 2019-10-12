#  自定义控件
###  一、实现步骤
1. 继承View类或其子类　
2. 重写view中的一些方法
3. 为自定义View类增加属性（两种方式）
4. 绘制控件（导入布局）
5. 响应用户事件
6. 定义回调函数（根据自己需求来选择）
	
### 二、需要被重写的方法
	
- onDraw() 具体的视图都要覆写该函数来实现自己的绘制
- onLayout() 为viewGroup类型布局子视图用。
- onMeasure() 用于计算视图大小（即长和宽）的方式，并通过setMeasuredDimension(width, height)保存计算结果。
- onTouchEvent 定义触屏事件来响应用户操作。

### 三.自定义控件的三种方式
1. 继承已有的控件
2. 继承一个布局文件
3. 继承view

### 四.自定义属性
1. 在布局文件中直接加入属性，在构造函数中去获得
2. 在res/values/ 下建立一个attrs.xml 来声明自定义view的属性

### 五.View的绘制与更新
View绘制分三个步骤，顺序是：onMeasure，onLayout，onDraw。调用invalidate方法只会执行onDraw方法；调用requestLayout方法只会执行onMeasure方法和onLayout方法，并不会执行onDraw方法。

所以当我们进行View更新时，若仅View的显示内容发生改变且新显示内容不影响View的大小、位置，则只需调用invalidate方法；若View宽高、位置发生改变且显示内容不变，只需调用requestLayout方法；若两者均发生改变，则需调用两者，按照View的绘制流程，推荐先调用requestLayout方法再调用invalidate方法。

*invalidate和postInvalidate: invalidate方法只能用于UI线程中，在非UI线程中，可直接使用postInvalidate方法。*
    
