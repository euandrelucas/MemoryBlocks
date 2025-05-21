# 🧠 MemoryBlocks

Um plugin de Minecraft que registra os blocos destruídos por cada jogador e permite revertê-los com um comando.

---

## ⚙️ Como funciona

- Sempre que um jogador quebra um bloco, o plugin registra o tipo e a localização.
- Ao executar `/reverter`, os blocos destruídos por aquele jogador são restaurados.

---

## 🚀 Como usar

1. Compile o plugin:

```bash
mvn clean package
````

2. Copie o arquivo `.jar` gerado em `target/MemoryBlocks-1.0-SNAPSHOT.jar` para a pasta `plugins/` do seu servidor Spigot ou Paper.

3. Inicie o servidor e use `/reverter` no jogo!

---

## 🛠️ Desenvolvimento

### Requisitos:

* Java 21
* Maven
* Servidor Spigot ou Paper

### Estrutura do projeto:

```
src/
 └── main/
     ├── java/com/memoryblocks/...
     └── resources/plugin.yml
```

---

## 👨‍💻 Autor

[André Lucas](https://github.com/euandrelucas)

---

## 📄 Licença

Este projeto está sob a licença MIT — sinta-se livre para usar e modificar.

