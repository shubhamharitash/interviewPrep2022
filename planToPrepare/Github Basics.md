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
![[Pasted image 20230710215717.png]]

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

