# 高级web接口

## 数据库
### Person 用户表
 - user_id 用户id
 - user_name 用户名
 - user_password 用户密码
 - user_photo 用户头像
 - view_id 心愿 景观id
 - view_id 足迹 景观id
 - view_id 收藏 景观id    
 

### View 景观表
 - view_id 景观id
 - view_name 景观名
 - view_location 经纬度
 - view_category 景观类别id(两种以上即可)
 - view_grade_number 评分数
 - view_wish_number 心愿数
 - view_trace_number 足迹数
 - view_collect_number 收藏数
 - view_detail 详细介绍
 - view_picture 图片
 - view_survey_address 调查问卷地址(流程里要求评分细则中没要求)
 

### ViewCategory 景观类别表
 - view_category_id 景观类别id
 - view_category_name 景观类别名
 - view_id 包含景观id
 


### CommentCategory 评论类别表
 - comment_category_id 评论类别id
 - comment_category_name 评论类别名
 


### Comment 评论表
 - comment_id 评论id
 - view_id 景观id
 - user_id 用户id
 - comment_grade 评分(0-5)
 - comment_detail 评论内容
 - comment_category_id 评论类别
 
 

### Search 搜索记录表
 - search_id 搜索id
 - search_detail 搜索内容
 - view_id 搜索匹配评论id
 



## 基本流程接口
### 主页
#### 1）地图
```
  getAllViewCategory() 无参数
  功能：获取所有景观类别
  return view_category_id,view_category_name 所有景观类别id和名字
```
```
  getCategoryViewLocation(category_id) 景观类别id  
  功能：获取景观类别对应的所有地址
  return view_id,view_location 该类别包含的所有景观id和地址 
```
#### 2) 顶部栏
```
  getAllViewCategory() 无参数
  功能：获取所有景观类别
  return view_category_id,view_category_name 所有景观类别id和名字
```
```
 getViewSorted(view_category_id,sorted_id) 景观类别id,排序依据(评分1收藏2足迹3心愿4) 
 功能：在不同景观类别下，根据评分排序依据进行排名并显示
 return view_id,view_name,view_grade_number(collect/grade/wish) 按照排序依据的景观id、景观名和对应评分数(收藏数/足迹数/心愿数)
```

#### 3)底部工具栏
注：项目列表和顶部栏相同
```
  getViewCommentGrade(view_id) 景观id
  功能：获取景观的总评分和各星级评分比例
  return all_comment_grade,one_star_percent,two_star_percent,three_star_percent,four_star_percent,five_star_percent 总评分，1-5星评分百分比
```
```
  getViewComments(view_id) 景观id
  功能：获取景观所有评论，包含用户名、评分和评论内容
  return user_id,comment_grade,comment_detail 评论用户名，打分，评论内容
```
```
  getViewDetail(view_id) 景观id
  功能：获取景观详细信息
  return view_detail 景观信息
```
```
  addViewTrack(user_id,view_id，add_id) 用户id，景观id、add_id和之前sorted_id相同(收藏2足迹3心愿4)
  功能：添加到该用户足迹、心愿和收藏
  return true 添加成功
```
```
  getViewPicture(view_id) 景观id
  功能：获取景观图片
  return view_picture 景观图片
```
```
  getViewLocation(view_id) 景观id
  功能：获取景观地址
  return view_Location 景观地址
```
```
  getAllCommentCategory() 无参数
  功能：获取所有评论分类
  return comment_category_id,comment_category_name 所有评论分类id和名字
```
```
  getCommentByCategory(comment_category_id) 评论分类id
  功能：获取该评论分类下的评论
  return comment_detail 该评论分类下的评论内容
```
```
  addComment(comment_category_id,user_id,comment_detail,comment_grade) 评论分类、用户id、评论内容和评分
```
### 附近
```
  getNeighborViewSorted(address,sorted_id) 我的当前位置,排序依据(评分1收藏2足迹3心愿4) 
  功能:依据不同排序依据，对当前位置附近景点进行排序
  return view_id,view_name,view_grade_number(collect/track/wish)附近的景观id、名称、评分(收藏数/足迹数/心愿数)
```
### 搜索
```
 getSearchHistory() 无参数
 功能：获取搜索记录
 return search_id,search_detail,view_id,view_name 搜索id、搜索内容，搜索匹配景观id和名字
```
``` 
 addSearch(search_detail) 搜索内容
 功能：添加入搜索历史
 return true 搜索记录添加成功(还可以进行匹配记录)
```
### 路线规划
调用api
### 我的
```
 register(user_name,user_password) 用户名和密码
 功能：注册用户
 return user_id 获取用户id
```
```
 addPhoto(user_id,user_photo) 用户头像
 功能：添加头像
 return true 头像添加成功
```
```
 login(user_id,user_password) 用户id和用户密码
 功能：登陆(同时支持第三方登陆)
 return true 登陆成功
```
```
 showUser(user_id,show_id) 用户id、show依据和之前sorted_id相同(收藏2足迹3心愿4)
 功能：获取该用户收藏、足迹或者心愿单
 return view_id,view_name,view_track_number(collect/wish) 景观id，景观名以及收藏数等
```








