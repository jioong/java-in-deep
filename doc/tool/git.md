# Git

![git 操作](./img/git-operations.png "git 操作")

## 配置

为所有的本地仓库配置配置用户信息。
1. `git config --globla uers.name "name"` 设置想要关联的提交事务的用户名。
2. `git config --global user.email "email` 设置想要关联的提交事务的邮箱地址。
3. `git config --global color.ui auto` 启用命令行彩色。

## 创建仓库

1. `git init [project-name]` 用指定的名字创建仓库。
2. `git clone [url]` 下载一个仓库以及它的所有历史记录。

## 改变

1. `git status` 列出所有待提交的新加的或修改的文件。
2. `git diff` 显示文件差异。
3. `git add [file]` 
4. `git --diff staged` 显示与`staging`之间的差异。
5. `git reset [file]` 
6. `git commit -m "descripe message" 提交

## 组改变

1. `git branch` 列出当前仓库的所有本地分支。
2. `git bracnh [branch-name]` 创建一个新的分支。
3. `git checkout [branch-name]` 签出指定的分支并更新工作区。
4. `git merge [branch]` 将指定分支的历史合入当前分支。
5. `git branch -d [branch-name]` 删除指定的分支。

## 重构文件名

1. `git rm [file]` 删除指定的文件并保留删除的动作。
2. `git rm -cached [file]` 从版本控制中删除文件，但保留本地文件。
3. `git mv [file-original] [file-renamed]` 改变文件名。


## 阻止追踪

`.gitignore`能阻止追踪一些文件。
1. `git ls-files --other --ignored --exclude-standard` 列出所有被忽视的文件。

## 保存片段

保存不完整的改变。
1. `git stash` 临时保存所有被改变的已追踪文件。
2. `git stash pop` 保存最近的`stashed`文件。
3. `git stash list` 列出所有的`stashed`改变。
4. `git stash drop` 丢弃最近的`stashed`改变。

## 查看历史

1. `git log` 列出当前分支的所有历史记录。
2. `git log --follow [file]` 列出指定文件的所有历史，包括改名。
3. `git diff [first-branch] ... [second-branch]` 列出两个分支之间的差异。
4. `git show [commit]` 列出指定提交的数据。


## 重提交

1. `git reset [commit]` 回退指定提交之后的所有提交。
2. `git reset --hard [commit]` 丢弃所有的历史和改变回退到指定提交

## 同步

1. `git fetch [bookmark]` 
2. `git merge [bookmark]/[branch]`
3. `git push [alias] [branch]` 
4. `git pull`

**参考资料**

1. [图解Git](http://marklodato.github.io/visual-git-guide/index-zh-cn.html '图解Git')