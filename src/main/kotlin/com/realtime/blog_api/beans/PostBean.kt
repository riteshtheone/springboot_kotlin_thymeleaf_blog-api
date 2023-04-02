package com.realtime.blog_api.beans

import java.util.Date

class PostBean {
     var postId: Int = 0
     var title: String = ""
     var content: String = ""
     var image: String = ""
     var postDate: Date = Date()
     var category: CategoryBean = CategoryBean()
     var user: UserBean = UserBean()
     var comments: Set<CommentBean> = HashSet()
}