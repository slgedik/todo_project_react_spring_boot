const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  app.use(
    '/todo', // Bu, proxy ayarlarının uygulanacağı API yolu
    createProxyMiddleware({
      target: 'http://localhost:4444', // Backend sunucusunun adresi ve portu
      changeOrigin: true,
    })
  );
};
