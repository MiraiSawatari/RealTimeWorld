# RealTimeWorld  
現実時間とMinecraft内のワールドの時間を一致させるプラグインです。  
1.15-1.16.5で動作確認済み Spigotサーバーで動きます  

## Config
```yaml
#IgnoreWorlds: World1,World2,World3... 
IgnoreWorlds:
#Interval 何Tickに一回同期するかどうか
Interval: 60
TimeZone: "Asia/Tokyo"

TimeOnTab: true
msg: "§a%year%§7/§a%month%§7/§a%day% §a%hour%§7:§a%min%"
```
IgnoreWorldsに書いたワールドでは時間の同期をしません  
Intervalで何Tickに一度時間を同期させるかを設定できます。 (このままで使うことをおすすめします。 あまり長くしすぎると大変なことになるかも)  
TimeZoneはお察しのとおりどこの場所の時間と一致させるかの指定ができます。 デフォルトでは「東京(日本標準時)」になっています。
  
TimeOnTabをtrueにするとtabに時間を表示できます。 形式はmsgでカスタマイズ可能  

年(例: 2004): `%year%`  
月: `%month%`  
日: `%day%`  
時間: `%hour%`  
分: `%min%`  
  
カラーコードは`§`のみ指定可能
