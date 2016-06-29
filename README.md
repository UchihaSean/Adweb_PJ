# 高级web接口

## 数据库
### Person 用户表
 - u_id 用户id
 - name 用户名
 - password 用户密码
 - photo 用户头像
 

### collect 收藏表
 - u_id 用户id
 - vid 景观id

### track 足迹表
 - u_id 用户id
 - v_id 景观id
 

### wish 心愿表
 - u_id 用户id
 - v_id 景观id

### View 景观表
 - v_id 景观id
 - name 景观名
 - location 经纬度
 - category 景观类别id(两种以上即可)
 - detail 详细介绍
 - picture_url 图片
 - survey 调查问卷(流程里要求评分细则中没要求)
 



### FlagCategory 标志表
 - f_c_id 标志类别id
 - f_id 标志id
 - name 标志名


### FlagView 标志景观表
- f_id 标志id
- v_id 景观id
- f_v_location 标志在该景观内的地址

### Comment 评论表
 - c_id 评论id
 - v_id 景观id
 - u_id 用户id
 - grade 评分(0-5)
 - detail 评论内容
 
 

 



## 基本流程接口
### 主页
#### 1）地图
```
  /AllViewCategory
  getAllViewCategory() 无参数
  功能：获取所有景观类别
  return view_category_id,view_category_name 所有景观类别id和名字
```
```
  /CategoryViewLocation
  getCategoryViewLocation(category_id) 景观类别id  
  功能：获取景观类别对应的所有地址
  return view_id,view_location 该类别包含的所有景观id和地址 
```
#### 2) 顶部栏
```
  /AllViewCategory
  getAllViewCategory() 无参数
  功能：获取所有景观类别
  return view_category_id,view_category_name 所有景观类别id和名字
```
```
  /ViewSorted
  getViewSorted(view_category_id,sorted_id) 景观类别id,排序依据(评分1收藏2足迹3心愿4) 
  功能：在不同景观类别下，根据评分排序依据进行排名并显示
  return view_id,view_name,view_grade_number(collect/grade/wish) 按照排序依据的景观id、景观名和对应评分数(收藏数/足迹数/心愿数)
```

#### 3)底部工具栏
注：项目列表和顶部栏相同
```
  /ViewCommentGrade
  getViewCommentGrade(view_id) 景观id
  功能：获取景观的总评分和各星级评分比例
  return comment_grade_number,one_star_percent,two_star_percent,three_star_percent,four_star_percent,five_star_percent 总评分，1-5星评分百分比
```
```
 /ViewComments
  getViewComments(view_id) 景观id
  功能：获取景观所有评论，包含用户名、评分和评论内容
  return user_id,comment_grade,comment_detail 评论用户名，打分，评论内容
```
```
  /ViewDetail
  getViewDetail(view_id) 景观id
  功能：获取景观详细信息
  return view_detail 景观信息
```
```
  /AddView
  addView(user_id,view_id，add_id) 用户id，景观id、add_id和之前sorted_id相同(收藏2足迹3心愿4)
  功能：添加到该用户足迹、心愿和收藏
  return true 添加成功
```
```
 /ViewPicture
  getViewPicture(view_id) 景观id
  功能：获取景观图片
  return view_picture_url 景观url
```
```
  /ViewLocation
  getViewLocation(view_id) 景观id
  功能：获取景观地址
  return view_Location 景观地址
```

```
  /FlagByCategory
  getFlagByCategory(flag_category_id) 评论分类id(活动类型1场所类型2建议3)
  功能：获取该评论标志分类下
  return flag_detail 该评论标志分类下的评论内容
```
```
  /AddFlag
  addFlag(flag_id，view_id) 标志id
  功能：添加标志
  return true 添加成功
```
```
  /AddComment
  addComment(user_id,view_id,comment_detail,comment_grade) 用户id、景观id、评论内容和评分
  功能：添加评论
  return true 添加成功
```
### 附近
```
  /NeighborViewSorted
  getNeighborViewSorted(address,sorted_id) 我的当前位置,排序依据(评分1收藏2足迹3心愿4) 
  功能:依据不同排序依据，对当前位置附近景点进行排序
  return view_id,view_name,view_grade_number(collect/track/wish)附近的景观id、名称、评分(收藏数/足迹数/心愿数)
```

### 路线规划
调用api
### 我的
```
  /Register
  register(user_name,user_password) 用户名和密码
  功能：注册用户
  return user_id 获取用户id
```
```
  /AddPhoto
  addPhoto(user_id,user_photo) 用户头像
  功能：添加头像
  return true 头像添加成功
```
```
  /Login
  login(user_id,user_password) 用户id和用户密码
  功能：登陆(同时支持第三方登陆)
  return true 登陆成功
```
```
  /ShowUserDetail
  showUserDetail(user_id,show_id) 用户id、show依据和之前sorted_id相同(收藏2足迹3心愿4)
  功能：获取该用户收藏、足迹或者心愿单
  return view_id,view_name,view_track_number(collect/wish) 景观id，景观名以及收藏数等
```








