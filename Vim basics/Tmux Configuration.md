#### Config File

```shell
touch $HOME/.config/tmux/tmux.conf
```

tmux.conf
```
# Set True Color
set-option -ga terminal-overrides ",xterm-256color:Tc"

# Set prefix
unbind C-b
set -g prefix C-space
bind C-space send-prefix

# Shift Alt vim keys to switch windows
bind -n M-H previous-window
bind -n M-L next-window

set -g @plugin 'tmux-plugins/tpm'
set -g @plugin 'tmux-plugins/tmux-sensible'
set -g @plugin 'christoomey/vim-tmux-navigator'

run '~/.tmux/plugins/tpm/tpm'
```

#### Basics of Tmux

###### Building blocks of Tmux

![[Tmux Configuration-1685301754836.jpeg]]
![[Tmux Configuration-1685301826015.jpeg]]
Window is container to one or more panes
Windows in session are shown at bottom of screen

Panes are splits in window, which represent individual terminal session


