
const KEY = 'user';

const getUser = (storage: Storage) => {
  const str = localStorage.getItem(KEY);
  return str ? JSON.parse(str) : null;
}

const setUser = (storage: Storage, user: Object) => {
  storage.setItem(KEY, JSON.stringify(user));
}

const removeUser = (storage: Storage) => {
  storage.removeItem(KEY);
}

export {getUser, setUser, removeUser}