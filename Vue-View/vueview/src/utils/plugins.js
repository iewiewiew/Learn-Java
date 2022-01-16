// 放重复点击
export function preventDuplicateClick(callback, delay = 1000) {
  let lastClickTime = 0;

  return function(...args) {
      const now = Date.now();
      if (now - lastClickTime >= delay) {
          lastClickTime = now;
          return callback.apply(this, args);
      }
  };
}