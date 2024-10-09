<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<br/>

# Servidors

## Exemple Canvas + Sockets

Aquest exemple mostra com poden interactuar dos clients sobre un *Canvas* a través de WebSockets.

Per fer-lo anar, cal obrir tres terminals diferents. Una pel servidor i dues pels clients:

Mantenir el servidor funcionant:
```bash
cd "Exemple Sockets"
./run.sh com.server.Main
```

Un cop el servidor està llest, obrir dos clients:
```bash
cd "Exemple Sockets"
./run.sh com.client.Main
```

<br/>
<center>
<video width="100%" controls allowfullscreen>
  <source src="./assets/exSockets.mov" type="video/mp4">
</video>
</center>
<br/>

**Nota**: Per sortir del servidor escriure 'exit' a la consola.

### Servidors remots (mirar teoria Serveis i processos)

Configurar els arxius:

```text
proxmoxRun.sh
proxmoxStop.sh
```

Amb els vostres paràmetres del proxmox:

* Nom d'usuari per accedir al Proxmox
* Arxiu amb la clau privada RSA
* Port al que funciona el servidor

```bash
DEFAULT_USER="nomUsuari"
DEFAULT_RSA_PATH="$HOME/Desktop/Proxmox IETI/id_rsa"
DEFAULT_SERVER_PORT="3000"
```

Per pujar i arrencar el servidor al Proxmox, executar:

```bash
proxmoxRun.sh
```

Per aturar el servidor del Proxmox, executar:

```bash
proxmoxStop.sh
```

**Nota**: Abans d'executar el servidor al Proxmox, cal asseguar-se que té el port 80 redireccionat cap al 3000:

Connectar-se per SSH al proxmox:

```bash
ssh -i id_rsa -p 20127 nomUsuari@ieticloudpro.ieti.cat
```

Redireccionar el port 80 cap al 3000:

```bash
sudo iptables-save -t nat | grep -q -- "--dport 80" || sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 3000
```

Per desfer la redirecció anterior:

```bash
sudo iptables -t nat -D PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 3000
sudo iptables -t nat -L -n -v
```


