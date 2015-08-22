# RecyclerViewTest
RecyclerView_layout； 是主layout

image_item_layout:每个item的layout

Fruit.java:一项item中需要到到数据集合，与viewHolder相对应，viewHolder相当将Fruit装到image_item_layout中的控件

ImageTextAdapter:将数据与recyclerview适配起来

注意：

使用shape对每个item的view设置形状，发现效果不对，才认真的尝试了下shape中一些属性。下面是自己做的一个笔记
shape，其中有个padding,padding指的是content距离view边缘的，Padding to apply to the containing View element (this pads the position of the View content, not the shape).对于imageView,content就是图片，所以如果用了shape的padding,例如如果设置了  padding top=5dp,相当把图片在往下推了5dp(假设我们将item的大小设置为  100dp)，如果将 top=100dp 那么将看不到图片了，只能看到了  solid填充的颜色而已了。
layout_margin:Specifies extra space on the left, top, right and bottom sides of this view.
那么是不是觉得可以为了设置出线的效果，设置shape 中的padding的四个值都是0，只设置 stroke,但是发现对于button才可以这么用，但是对于imageview ,  要看出线的效果，必须要设 padding,  如果是0的话，线的效果是看不到的。发现stroke是根据 padding 来设置
例如
 <stroke
        android:width=“10dp"
        android:color="@android:color/black" />

    <padding
        android:bottom="0dp"
        android:left="2dp"
        android:right="2dp"
        android:top="20dp" />
这样看出的线条，在上的位置有10dp的粗，在左右只有2dp的粗，所以
自己的想法是，应该是padding，是content(图片)相对view边缘的距离 dp,而stroke是针对view来说，相当是对背景而设置边线，所以如果覆盖图片上去，而也不留 padding，就看不到了？因为在button上，padding都设置为0，stroke 是会起作用的
