
第一次学习编辑器，总结一下vi的模式和部分指令。<br><br>
- **命令模式**：光标移动，字符删除，复制区段，进入插入模式按"i"。
- **插入模式**：输入文本，切换命令模式按"Esc"。
- **底行模式**：保存，退出编辑，设置环境等。
<br>
<br>
Vi的在Linus下新建文件和sublime类似,使用"Vi FileName"形式新建或打开文件，刚进入vi是命令模式，需要先切换到插入模式。
输入以后再按":"切换到底行模式，输入"wq"保存退出。<br>
<br>
列出几种常用的命令: <br>
- 插入模式：
    - 'a'从光标下一个位置开始插入文本 
    - 'o'插入新一行，从行首开始输入（另起一行）
- 命令模式：
			- dd 删除所在行
			- x 删除光标后的一个字符
			- X 删除光标前的一个字符
			- #yy 复制光标所在的#行
			- P粘贴
- 底行模式：
			- wq 保存退出
			- q! 不保存退出
			- w filename重命名保存
			- set nu 在文本上出现行号
			- # 跳转到对应的文章行数# 
			- /或?key，查询key。
<h2>上古神器——Vim</h2>
<br>
Vim编辑器它Linux上的地位就像Edit程序在DOS上一样，虽然没有图形化界面，不像sublime一样精美，但是是效率很高的编辑器,可以说是最为优秀经典的代码编辑器。<br>
它的最大特色是完全使用键盘命令进行编辑，脱离了鼠标操作虽然使得入门变得困难，但上手之后键盘流的各种巧妙组合操作却能带来极为大幅的效率提升，如今被看作是高手、Geek们专用的编辑器。
<br>
<br>
<h1>JAVA</h1>
<br>
在上学期就选修了java程序设计，所以对java熟悉一些，这次翻阅资料，了解了java的GUI以及对java编译解释过程更加清晰。
1. javac:将源文件编译成字节码，生成filename.class文件。
2. java: 将字节码放到解释器上执行。
3. java中数据类型和C++非常接近，如boolean,char,int,double,float,但需要注意String是一个类不是基本数据类型，但是非常有用。
4. java中分支判断语句，循环语句都和C++很相近,但java不支持C++灵活的指针操作（很庆幸）。
5. Java中AWT提供了抽象窗口包，Swing为GUI设计包，提供了布局管理，其中GridLayout就可以应用到本次的小程序中。
<br>
<br>
<h1>Ant<h1>
<h1>JUnit<h1>
<h1>Ant</h1>
<h1>JUnit</h1>
