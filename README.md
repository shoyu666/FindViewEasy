findviewEasy

#### 特性
- view注入
- onClick绑定
- view注入不增加class (这点是和ButterKnife本质的区别)
- 和 ButterKnife api 保持一致


#### 使用


```
import com.shoyu666.findviewlib.BindView;
import com.shoyu666.findviewlib.ButterKnife;
import com.shoyu666.findviewlib.OnClick;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.textview)
    public TextView textview;

    @BindView(R.id.button)
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        textview.setText("xxxxxxxxxxxxxxx");
        button.setText("bbbbbbbbbbbbbbb");
    }

    @OnClick({R.id.button, R.id.textview})
    public void onClick(View v) {
        Toast.makeText(this, "触发点击", Toast.LENGTH_LONG).show();
    }
}
```

#### 原理

```
编译阶段class插入代码
public void likeButterKnife(View var1) {
       this.textview = (TextView)var1.findViewById(2131427413);
       this.button = (Button)var1.findViewById(2131427414);
       var1.findViewById(2131427414).setOnClickListener(this);
       var1.findViewById(2131427413).setOnClickListener(this);
}
```
#### 优点
- view注入的同时,没有ButterKnife 增加 *_ViewBinding类的负担,这点对于大工程比较实用

#### todo
- ...

#### 编译


```
step1
app/build.gralde
先注释掉
//buildscript {
//    repositories {
//        maven {
//            url 'file:../lib'
//        }
//        mavenCentral()
//    }
//    dependencies {
//        classpath group: 'com.shoyu666', name: 'findviewplugin',
//                version: '1.0-SNAPSHOT'
//    }
//}
//apply plugin: 'com.shoyu666.findvieweasyplugin'


step2
findviewplugin build.gralde
运行 右侧 uploadArchives  生成lib

step3
取消step1的注释,运行
```
