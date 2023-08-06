![[Github Basics-1688932618991.jpeg]]

https://www.atlassian.com/git/tutorials/merging-vs-rebasing

#### Detaching head
HEAD generally points towards the latest commit of the branch ur on.
However in **Detach State** it points to a specific commit
For going to detach state
```
git checkout <hashIdOfCommit>
```

###### Moving in Git tree
```
# move HEAD to parent commit of the current one1
git checkout main^
```

#### Branch Forcing
![[Github Basics-1689006437992.jpeg]]

#### Reversing changes
https://towardsdatascience.com/mastering-git-reset-v-revert-12701108a451
###### Reset
```
git reset HEAD~3
```
This command can be used to move to current branch to a previous commit in history. It does so by changing the commit history

- `--soft` flag means that although we revert back two commits, the changes in those commits remain as part of the working directory and are staged to be committed. If at this point you run `git commit` then all the changes that were part of commits `C` and `B` will be committed and you will be at the same stage as you were before the reset.
- `--mixed` is the default flag which is used when no other flag is specified. With this, while the working directory is not changed, meaning that no files are changed, none of these changes are staged to be committed. This means that if you run `git status` you will see all the files that were changed are in red, waiting to be committed.
- `--hard` flag will change both the staged snapshot and the working directory to remove all the changes from commits `B` and `C` . This means you won’t see the changes from `B` or `C` at all and it will be like they never even existed. This is the most extreme reset and means that it will change everything back to how it was after commit `A` .

###### Revert
```
git revert HEAD
```
This command undoes all the changes in a particular commit. Used for making changes in a public repository since instead of destroying the commit, it undo the changes and add it as a new commit to the commit history.

#### Cherry Pick
If you want some commit changes in your branch, you can simply do cherry pick
```
git cherry-pick C2 C4
```
![[Github Basics-1689011312244.jpeg]]
![[Github Basics-1689011338045.jpeg]]

#### Rebase
https://www.atlassian.com/git/tutorials/merging-vs-rebasing
```
git rebase -i HEAD~3
```
will help you reorder last 3 commits in corrent branch

```
git rebase -i main
```
will add all commits in local branch ahead of commits in main
**Be carefull while doing this since it changes local branch completely, can be distructive**

```
git rebase <source_whos_changes_reqd> <branch_receiving_changes>
```

#### Adding Staged changes to the same commit
```
git commit --amend
```

#### Remote Changes 
For downloading remote repo
```shell
git clone <url>
```
git maintains two branches here, origin/main and origin, so that it can keep track of what work is done local and what is there on the remote

Whenever we checkout remote branch, we go into detached HEAD mode. Any commit made will not be updated in the remote branch.

```shell
git fetch
```
Used for fetching commits from remote repository
![[Github Basics-1689093907611.jpeg]]

**fetch** command doesn't change the state of local repository, only remote repository gets updated.
It can be referred to as the download step.

once we have the commits in **origin/main** branch, we can easily incorporate those changes using traditional git methods like cherry-pick, merge, rebase.

```shell
git pull
```
This command does the job of both fetching the remote changes and updating the local repository

![[Github Basics-1689096704850.jpeg]]

```shell
git push
```
This command pushes the changes in local repository to remote repository

###### Updating changes in Remote
![[Github Basics-1689097449303.jpeg]]

For resolving above scenario, we can either
```shell
git fetch
git rebase o/main
git push
```

or 
```shell
git fetch
git merge o/main
git push
```

![[Github Basics-1689097755431.jpeg]]

```shell
git pull --rebase
git push
``` 

```shell
git pull
git push
```
both above can be used to update changes to remote repository

#### Changing Tracking of Branches

```shell
git checkout -b foo origin/main
git pull
```

This will update any new commits in **origin/main** to **foo**

#### Advanced Details
###### How git push works?
![[Github Basics-1689112323665.jpeg]]

```
git push origin <src>:<dest>
```
Here, we have specified source of commits, destination remote branch. If the branch doesn't exists at remote it will create a new branch at remote

![[Github Basics-1689136480995.jpeg]]
![[Github Basics-1689136490606.jpeg]]

###### How git fetch works?
Pretty similar to push except in reverse direction
```
git fetch
```
It updates all remote branches on local machine(downloading step)

```
git fetch origin main
```
It updates any new commits in remote onto origin/main

💀
```
git fetch foo:main 
```
it updates all the commits in origin/foo branch to local main branch. Unlike normal fetch behaviour, it is able to directly add commits to the local branch from remote branch at remote repository

![[Github Basics-1689138440997.jpeg]]
![[Github Basics-1689138457937.jpeg]]
```shell
git pull origin main:foo
```

is equivalent to 
```shell
git fetch origin main:foo
git merge foo
```
