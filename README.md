findviewEasy

#### 特性
- view注入 
- view注入不增加class (这点是和ButterKnife本质的区别)
- 和 ButterKnife api 保持一致


#### 使用


```
import com.shoyu666.findviewlib.BindView;
import com.shoyu666.findviewlib.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview) //注解
    public TextView textview;

    @BindView(R.id.button)
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//调用了编译阶段插入的方法 likeButterKnife(View v)
        textview.setText("xxxxxxxxxxxxxxx");
        button.setText("bbbbbbbbbbbbbbb");
    }
}
```

#### 原理

```
编译阶段class插入代码
public void likeButterKnife(View var1) {
        this.textview = (TextView)var1.findViewById(2131427413);
        this.button = (Button)var1.findViewById(2131427414);
}
```
#### 优点
- view注入的同时,没有ButterKnife 增加 *_ViewBinding类的负担,这点对于大工程比较实用
-
#### todo
- onClick注入
- ...