```shell
ffmpeg -video_size 1920x1080 -framerate 75 -f x11grab -i :1.0 -c:v libx264rgb -crf 0 -preset ultrafast -color_range 2 $(date).mp4
```

```shell
ffmpeg -video_size 1920x1080 -framerate 60 -f x11grab -i :1.0+100,200 -f alsa -ac 2 -i hw:0 $(date).mp4
```

```
ffmpeg -video_size 1920x1080 -framerate 25 -f x11grab -i :1.0 -f alsa -ac 2 -i pulse $(date).mp4
```

Best command to record only mic audio with screen
```shell
ffmpeg -video_size 1920x1080 -framerate 60 -f x11grab -i :1.0 -f alsa -ac 2 -i pulse "$(date).mp4"
```

#### Best command to remove white noise
```shell
ffmpeg -i 'inputFile.mkv' -af "afftdn=nf=-25" editedFileV1.mkv
ffmpeg -i 'editedFileV1.mkv' -af "afftdn=nf=-25" editedFileV2.mkv
ffmpeg -i 'editedFileV2.mkv' -af "highpass=f=200, lowpass=f=3000" editedFileV3.mkv
ffmpeg -i editedFileV3.mkv -af "volume=4" finaloutput.mp4
```

```
ffmpeg -i file3.mp4 -af "volume=4" finaloutput.mp4
```

```
ffmpeg -i '2023-06-25 16-49-53.mkv' -af "afftdn=nf=-25" "observerPattern1.mp4"
```

```
ffmpeg -i "2023-06-25 16-49-53.mkv" -vcodec libx264 -crf 25 -filter:v fps=60 "observerPatternV2.mp4"
```

```
ffmpeg -i 'observerPatternPart2.mp4' -vcodec h264_nvenc -af "afftdn=nf=-25"observerPatternPart2v2.mp4
```