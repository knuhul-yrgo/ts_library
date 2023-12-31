const joobyPort = 8080
const vuePort = 3000
const proxyPort = 8282

const joobyUrl = `http://127.0.0.1:${joobyPort}/`
const vueUrl = `http://127.0.0.1:${vuePort}/`

const express = require('express');
const { createProxyMiddleware } = require('http-proxy-middleware');
const app = express();

app.use('/api', createProxyMiddleware({ target: joobyUrl, pathRewrite: { '^/api': '/' }, changeOrigin: true }));
app.use('/', createProxyMiddleware({ target: vueUrl, changeOrigin: true }));

app.listen(proxyPort);
