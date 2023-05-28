#### Config File

```shell
touch $HOME/.config/tmux/tmux.conf
```

tmux.conf
```
set -g @plugin 'tmux-plugins/tpm'
set -g @plugin 'tmux-plugins/tmux-sensible'

run '~/.tmux/plugins/tpm/tpm'
```

#### Basics of Tmux

###### Building blocks of Tmux

![[Tmux Configuration-1685301754836.jpeg]]
![[Tmux Configuration-1685301826015.jpeg]]
Window is container to one or more panes
Windows in session are shown at bottom of screen

Panes are splits in window, which represent individual terminal session


