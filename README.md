# 📌 Resumen
`<autor>`: Miguel Rodrigo Armas Abt

---

A la fecha 05/2025, `r2dbc-mssql` no tiene soporte para la integración con Azure KeyVault. Sin embargo, se puede optar por alguno de los siguientes enfoques para resolver los campos Always Encrypted:

1. `r2dbc + jdbc`: Para aplicaciones reactivas, altamente concurrentes y que requieran mantener el `event-loop` libre, el enfoque híbrido es el más óptimo.
2. `jdbc`: Para aplicaciones que no son masivamente concurrentes, una sola llamada JDBC podría ser más rápida y fácil de mantener.

---

## 📦 [user-v1](user-v1/README.md)
- Consulta de usuario.
- La solución aplica un enfoque híbrido. Se aprovecha el pool reactivo de `r2dbc` para las lecturas ligeras (IDs, metadatos) y con `jdbc` se resuelven los campos Always Encrypted.

<img src="./diagrams.svg" width="400" height="280">