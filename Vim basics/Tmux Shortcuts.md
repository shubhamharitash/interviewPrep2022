https://tmuxcheatsheet.com/
#### Prefix Key
Used for giving commands to tmux
Default: `Ctrl + B`
Set in config: `Ctrl + Space`

Press prefix, release then press the required command

#### Shortcuts
> Window commands

prefix + c: new window
prefix + number: select that index window
prefix + p/n: cycle between windows
prefix + '':": to use commands
prefix + &: close a given window

> Pane Commands

prefix + %: Horizontal Split
prefix + ": Vertical Split
prefix + arrowkeys: navigate between panes

![[Screencast1.webm]]

prefix + q: show a number on panes which if pressed switches to that pane

![[Screencast3.webm]]

prefix + z: toggle that pane to take up full screen
prefix + !: converts a pane to window
prefix + x: closes the pane

> Session commands

0) List All sessions
if in tmux
prefix + s

if not in tmux
tmux ls

2) Create a new tmux session
```
# type tmux in terminal without being already in a session
tmux
```
2) While in tmux, new command can create new session
```
:new
```
3) While in tmux, new command can also create named session
```
:new -s adi_session
```
4) prefix + w: preview windows in each session
5) h and l keys can be used to toggle hierarchy
![[Screencast2.webm]]

6) Attach to a session using
```
tmux attach -t "session_name"
```

7) ![[Tmux Shortcuts-1685309413663.jpeg]]
8) prefix + d: exit without killing session
9) There are two key bindings. **prefix + Ctrl-s** to save tmux environment and **prefix + Ctrl-s** to restore tmux environment. It's as simple as that.

#### Commands
1) Switch panes from 1 to 0
```
:swap-window -s 0 -t 1
```
2) New session with a name
```
tmux new -s my-session
```
3) Attach to a session using
```
tmux attach -t "session_name"
```
4) Kill all windows except the one which is open
```
:kill-windows -a
```
